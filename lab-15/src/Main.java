import task3.*;
import task1.*;
import task2.*;

public class Main {

    public static void main(String[] args) {
        scenarioStandard();
        scenarioLuxuryAndChalet();
        scenarioFamily();
        task1();
        task2();
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

    public static void task1() {
        Logger.reset();
        Logger.section("Завдання 1. Стан номера");

        Room room = new Room(new FreeCleanState());

        Logger.log("Main", "Створено номер: вільний і прибраний");

        room.book();

        room.checkIn();

        room.checkOut();

        room.checkIn();

        room.clean();

        room.repair();

        room.book();

        Logger.log("Main", "Демонстрацію завершено");
    }

    public static void task2() {
        Logger.reset();
        Logger.section("Завдання 2. Розрахунок вартості проживання");

        double pricePerNight = 5000;
        int nights = 5;

        Booking booking = new Booking(
                pricePerNight,
                nights,
                new StandardPrice()
        );

        Logger.log("Main", "Створено бронювання: люкс, 5 ночей");

        double standardPrice = booking.calculatePrice();

        Logger.log("Main", "Вартість за стандартним тарифом: "
                        + standardPrice + " грн");

        booking.setStrategy(new SeasonalPrice());

        double seasonalPrice = booking.calculatePrice();

        Logger.log("Main", "Вартість за сезонним тарифом: "
                        + seasonalPrice + " грн");

        booking.setStrategy(new RegularGuestPrice());

        double regularGuestPrice = booking.calculatePrice();

        Logger.log("Main", "Вартість для постійного гостя: "
                        + regularGuestPrice + " грн");

        booking.setStrategy(new EarlyBookingPrice());

        double earlyBookingPrice = booking.calculatePrice();

        Logger.log("Main", "Вартість за раннього бронювання: "
                        + earlyBookingPrice + " грн");

        booking.setStrategy(new LastMinutePrice());

        double lastMinutePrice = booking.calculatePrice();

        Logger.log("Main", "Вартість за тарифом останніх хвилин: "
                        + lastMinutePrice + " грн");

        Logger.log("Main", "Демонстрацію завершено");
    }
}