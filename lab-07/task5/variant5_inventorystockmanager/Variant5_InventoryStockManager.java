package variant5_inventorystockmanager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Variant5_InventoryStockManager {

    // ---------- Доменна модель ----------
    public static class StockAdjustment {  // переносить дані про коригування товару
        private String itemSku;
        private String warehouseZone;
        private int quantityDelta;

        public String getItemSku() { return itemSku; }
        public void setItemSku(String itemSku) { this.itemSku = itemSku; }
        public String getWarehouseZone() { return warehouseZone; }
        public void setWarehouseZone(String warehouseZone) { this.warehouseZone = warehouseZone; }
        public int getQuantityDelta() { return quantityDelta; }
        public void setQuantityDelta(int quantityDelta) { this.quantityDelta = quantityDelta; }
    }

    public interface InventoryRepository {   // абстракції
        void updateStock(String sku, int delta);
    }

    public interface ShelfBeacon {
        void signalShelfLight(String zone, String sku);
    }

    public interface StockEventLogger {
        void logStockEvent(String sku, int delta);
    }

    //Низькорівневі реалізації
    public static class MongoInventoryRepository implements InventoryRepository {
        @Override
        public void updateStock(String sku, int delta) {
            System.out.println("[MongoDB Storage] Залишок для SKU '" + sku + "' змінено на " + delta + " шт.");
        }
    }

    public static class MqttWarehouseBeaconClient implements ShelfBeacon {
        @Override
        public void signalShelfLight(String zone, String sku) {
            System.out.println("[MQTT Protocol] Надіслано сигнал на радіо-маячок стелажа у зоні '" + zone + "' для SKU '" + sku + "'.");
        }
    }

    public static class JsonFileReportLogger implements StockEventLogger {
        @Override
        public void logStockEvent(String sku, int delta) {
            // Формат JSON відомий лише цій реалізації, а не бізнес-логіці.
            String json = "{\"sku\":\"" + escape(sku) + "\", \"delta\":" + delta + "}";
            System.out.println("[JSON File Logger] Додано лог-запис у stock_events.json: " + json);
        }

        private static String escape(String value) {
            return value.replace("\\", "\\\\").replace("\"", "\\\"");
        }
    }

    //Підміни для перевірки без реальної інфраструктури

    public static class InMemoryInventoryRepository implements InventoryRepository {
        private final Map<String, Integer> stock = new HashMap<>();

        @Override
        public void updateStock(String sku, int delta) {
            stock.merge(sku, delta, Integer::sum);
        }

        public int getQuantity(String sku) {
            return stock.getOrDefault(sku, 0);
        }
    }

    public static class RecordingShelfBeacon implements ShelfBeacon {
        private final List<String> signals = new ArrayList<>();

        @Override
        public void signalShelfLight(String zone, String sku) {
            signals.add(zone + ":" + sku);
        }

        public List<String> getSignals() { return signals; }
    }

    public static class InMemoryStockEventLogger implements StockEventLogger {
        private final List<String> events = new ArrayList<>();

        @Override
        public void logStockEvent(String sku, int delta) {
            events.add(sku + ":" + delta);
        }

        public List<String> getEvents() { return events; }
    }

    // ---------- Високорівнева бізнес-логіка ----------

    public static class InventoryStockManager {
        private final InventoryRepository repository;
        private final ShelfBeacon beacon;
        private final StockEventLogger logger;

        // Constructor Injection: усі залежності приходять ззовні й не створюються через new.
        public InventoryStockManager(InventoryRepository repository, ShelfBeacon beacon, StockEventLogger logger) {
            this.repository = Objects.requireNonNull(repository, "repository");
            this.beacon = Objects.requireNonNull(beacon, "beacon");
            this.logger = Objects.requireNonNull(logger, "logger");
        }

        public void adjustStockLevel(StockAdjustment adjustment) {
            if (adjustment == null) {
                throw new IllegalArgumentException("Некоректні дані коригування товару.");
            }
            String sku = adjustment.getItemSku();
            if (sku == null || sku.isBlank()) {
                throw new IllegalArgumentException("Некоректні дані коригування товару.");
            }

            repository.updateStock(sku, adjustment.getQuantityDelta());
            beacon.signalShelfLight(adjustment.getWarehouseZone(), sku);
            logger.logStockEvent(sku, adjustment.getQuantityDelta());
        }
    }

    //Composition Root
    private static StockAdjustment adjustment(String sku, String zone, int delta) {
        StockAdjustment a = new StockAdjustment();
        a.setItemSku(sku);
        a.setWarehouseZone(zone);
        a.setQuantityDelta(delta);
        return a;
    }

    public static void main(String[] args) {
        // 1) Production-збірка: реальні Mongo, MQTT та JSON-лог.
        System.out.println("=== Production wiring ===");
        var production = new InventoryStockManager(
                new MongoInventoryRepository(),
                new MqttWarehouseBeaconClient(),
                new JsonFileReportLogger());
        production.adjustStockLevel(adjustment("SKU-100", "A1", 5));

        // 2) Тестова збірка: ті самі бізнес-правила, але без жодної інфраструктури.
        System.out.println("\n=== Test wiring (без реальної інфраструктури) ===");
        var repo = new InMemoryInventoryRepository();
        var beacon = new RecordingShelfBeacon();
        var log = new InMemoryStockEventLogger();
        var testManager = new InventoryStockManager(repo, beacon, log);

        testManager.adjustStockLevel(adjustment("SKU-100", "A1", 10));
        testManager.adjustStockLevel(adjustment("SKU-100", "A1", -3));

        System.out.println("Залишок SKU-100 у пам'яті: " + repo.getQuantity("SKU-100"));
        System.out.println("Сигнали маячка: " + beacon.getSignals());
        System.out.println("Події: " + log.getEvents());

        // 3) Fail-fast: некоректні дані відхиляються до будь-яких побічних ефектів.
        try {
            testManager.adjustStockLevel(adjustment(" ", "A1", 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Fail-fast: " + e.getMessage());
        }
        try {
            new InventoryStockManager(null, beacon, log);
        } catch (NullPointerException e) {
            System.out.println("Fail-fast: відсутня залежність '" + e.getMessage() + "'");
        }
    }
}