import task1.*;
import task2.*;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
    }

    // Ситуація 1 (Visitor): операції над нарахуваннями рахунку
    private static void task1() {
        Logger.reset();
        Logger.section("Завдання 1: операції над нарахуваннями рахунку (Visitor)");

        GuestBill bill = new GuestBill("Іваненко О.");
        bill.add(new AccommodationCharge("Люкс", 5, 4000));
        bill.add(new MealCharge("Сніданки", 10, 350));
        bill.add(new SpaCharge("Масаж", 1800));
        bill.add(new RentalCharge("Лижі", 3, 600));
        bill.add(new TouristTaxCharge(5, 40));

        bill.logState("Стан рахунку до операцій");

        Logger.section("Операція 1: розрахунок податків");
        TaxCalculationVisitor taxes = new TaxCalculationVisitor();
        bill.accept(taxes);
        Logger.log("Податки", "Результат: усього податків " + Logger.money(taxes.getTotalTax()));

        Logger.section("Операція 2: нарахування бонусних балів");
        BonusPointsVisitor bonuses = new BonusPointsVisitor();
        bill.accept(bonuses);
        Logger.log("Бонуси", "Результат: усього " + bonuses.getTotalPoints() + " балів");

        Logger.section("Операція 3: звіт для туроператора (новий клас)");
        TourOperatorReportVisitor report = new TourOperatorReportVisitor();
        bill.accept(report);
        Logger.log("Звіт туроператору", "Результат: послуги " + Logger.money(report.getServicesTotal())
                + ", збори " + Logger.money(report.getTaxesTotal()));

        bill.logState("Стан рахунку після операцій (не змінився)");
    }

    //Ситуація 2 (Iterator): обхід номерів готелю
    private static void task2() {
        Logger.reset();
        Logger.section("Завдання 2: обхід номерів готелю (Iterator)");

        Hotel hotel = createHotel();
        RoomCollection rooms = hotel;

        hotel.logState("Стан колекції до обходів");

        Logger.section("Обхід 1: покоївки, номери для прибирання (поверх за поверхом)");
        traverse("Покоївки", rooms.createCleaningIterator());

        Logger.section("Обхід 2: рецепція, вільні люкси (включно з котеджами)");
        traverse("Рецепція", rooms.createFreeRoomsIterator(RoomCategory.LUXURY));

        Logger.section("Обхід 3: технічна служба, усі номери корпусу Б");
        traverse("Технічна служба", rooms.createBuildingIterator("Корпус Б"));

        Logger.section("Обхід 4: покоївки і рецепція одночасно");
        RoomIterator housekeeping = rooms.createCleaningIterator();
        RoomIterator reception = rooms.createFreeRoomsIterator(RoomCategory.LUXURY);
        while (housekeeping.hasNext() || reception.hasNext()) {
            if (housekeeping.hasNext()) {
                Logger.log("Покоївки", "Наступний: " + housekeeping.next().describe());
            }
            if (reception.hasNext()) {
                Logger.log("Рецепція", "Наступний: " + reception.next().describe());
            }
        }

        hotel.logState("Стан колекції після обходів (не змінився)");
    }

    private static void traverse(String source, RoomIterator iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            Room room = iterator.next();
            Logger.log(source, room.describe());
            count++;
        }
        Logger.log(source, "Обхід завершено, номерів: " + count);
    }

    private static Hotel createHotel() {
        Hotel hotel = new Hotel();

        Building buildingA = new Building("Корпус А");
        Floor a1 = new Floor(1);
        a1.addRoom(new Room("101", RoomCategory.STANDARD, RoomStatus.FREE, "Корпус А, поверх 1"));
        a1.addRoom(new Room("102", RoomCategory.STANDARD, RoomStatus.NEEDS_CLEANING, "Корпус А, поверх 1"));
        a1.addRoom(new Room("103", RoomCategory.LUXURY, RoomStatus.FREE, "Корпус А, поверх 1"));
        Floor a2 = new Floor(2);
        a2.addRoom(new Room("201", RoomCategory.STANDARD, RoomStatus.OCCUPIED, "Корпус А, поверх 2"));
        a2.addRoom(new Room("202", RoomCategory.LUXURY, RoomStatus.NEEDS_CLEANING, "Корпус А, поверх 2"));
        a2.addRoom(new Room("203", RoomCategory.LUXURY, RoomStatus.FREE, "Корпус А, поверх 2"));
        buildingA.addFloor(a1);
        buildingA.addFloor(a2);

        Building buildingB = new Building("Корпус Б");
        Floor b1 = new Floor(1);
        b1.addRoom(new Room("301", RoomCategory.STANDARD, RoomStatus.NEEDS_CLEANING, "Корпус Б, поверх 1"));
        b1.addRoom(new Room("302", RoomCategory.LUXURY, RoomStatus.OCCUPIED, "Корпус Б, поверх 1"));
        Floor b2 = new Floor(2);
        b2.addRoom(new Room("401", RoomCategory.LUXURY, RoomStatus.FREE, "Корпус Б, поверх 2"));
        b2.addRoom(new Room("402", RoomCategory.STANDARD, RoomStatus.FREE, "Корпус Б, поверх 2"));
        buildingB.addFloor(b1);
        buildingB.addFloor(b2);

        Building cottages = new Building("Котеджі");
        cottages.addDetachedRoom(new Room("К1", RoomCategory.LUXURY, RoomStatus.FREE, "Котеджі, без поверху"));
        cottages.addDetachedRoom(new Room("К2", RoomCategory.LUXURY, RoomStatus.NEEDS_CLEANING, "Котеджі, без поверху"));
        cottages.addDetachedRoom(new Room("К3", RoomCategory.LUXURY, RoomStatus.OCCUPIED, "Котеджі, без поверху"));

        hotel.addBuilding(buildingA);
        hotel.addBuilding(buildingB);
        hotel.addBuilding(cottages);
        return hotel;
    }
}