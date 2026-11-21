import task3.*;

public class Main {

    public static void main(String[] args) {
        scenarioStandard();
        scenarioLuxuryAndChalet();
        scenarioFamily();
    }

    // Ситуація 1: підготовка стандартного номера
    private static void scenarioStandard() {
        Logger.reset();
        Logger.section("Сценарій 1: підготовка стандартного номера");

        RoomPreparation room = new StandardRoomPreparation("101");
        room.prepare();
    }

    // Ситуація 2: люкс і шале тією самою процедурою
    private static void scenarioLuxuryAndChalet() {
        Logger.reset();
        Logger.section("Сценарій 2: люкс і шале тією самою процедурою");

        RoomPreparation luxury = new LuxuryRoomPreparation("301");
        luxury.prepare();

        RoomPreparation chalet = new ChaletPreparation("501");
        chalet.prepare();
    }

    // Ситуація 3: нова категорія одним класом
    private static void scenarioFamily() {
        Logger.reset();
        Logger.section("Сценарій 3: нова категорія «сімейний номер»");

        RoomPreparation family = new FamilyRoomPreparation("205");
        family.prepare();
    }
}