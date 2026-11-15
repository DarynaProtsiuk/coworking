package task1_lab12;

import java.util.HashMap;
import java.util.Map;

public class RoomTypeFactory {
    private static final Map<String, RoomType> cache = new HashMap<>();

    public static RoomType getRoomType(String name) {
        RoomType type = cache.get(name);
        if (type == null) {
            type = createRoomType(name);
            cache.put(name, type);
            Logger.log("RoomTypeFactory", "створено нову категорію: " + name);
        }
        return type;
    }

    public static int getCreatedCount() {
        return cache.size();
    }

    // "довідник" даних категорій: викликається лише при першому запиті
    private static RoomType createRoomType(String name) {
        switch (name) {
            case "Стандарт":
                return new RoomType("Стандарт", "Затишний номер з видом на двір", 18,
                        new String[]{"Wi-Fi", "Телевізор"},
                        new String[]{"standard1.jpg", "standard2.jpg"}, 1500);
            case "Комфорт":
                return new RoomType("Комфорт", "Просторий номер з балконом", 25,
                        new String[]{"Wi-Fi", "Телевізор", "Міні-бар", "Балкон"},
                        new String[]{"comfort1.jpg", "comfort2.jpg"}, 2200);
            case "Сімейний":
                return new RoomType("Сімейний", "Дві спальні для родини з дітьми", 40,
                        new String[]{"Wi-Fi", "Телевізор", "Кухонна зона", "Дитяче ліжко"},
                        new String[]{"family1.jpg", "family2.jpg"}, 3000);
            case "Люкс":
                return new RoomType("Люкс", "Номер із панорамним видом на Карпати", 55,
                        new String[]{"Wi-Fi", "Телевізор", "Джакузі", "Камін", "Тераса"},
                        new String[]{"lux1.jpg", "lux2.jpg"}, 4500);
            default:
                throw new IllegalArgumentException("Невідома категорія: " + name);
        }
    }
}
