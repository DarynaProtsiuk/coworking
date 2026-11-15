package task3;
import task2_lab12.*;
import task1_lab12.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static LocalTime time = LocalTime.of(8, 0, 0); // умовний час


    public static void log(String source, String event) {
        System.out.println("[" + time.format(FORMAT) + "] [" + source + "] " + event);
        time = time.plusSeconds(1);
    }

    private static void task1() {
        Logger.log("Main", "Завдання 1: календар зайнятості номерів");

        HotelCalendar calendar = new HotelCalendar();
        calendar.build(60, 365, LocalDate.of(2027, 1, 1));

        Logger.log("Main", "Записів календаря: " + calendar.size());
        Logger.log("Main", "Об'єктів категорій: " + RoomTypeFactory.getCreatedCount());

        CalendarEntry first = calendar.getEntry(5, 0);
        CalendarEntry second = calendar.getEntry(5, 200);
        Logger.log("Main", "Запис 1: " + first.describe());
        Logger.log("Main", "Запис 2: " + second.describe());
        Logger.log("Main", "Посилаються на той самий об'єкт категорії (==): "
                + (first.getType() == second.getType()));
    }

    private static void task2() {
        Logger.log("Main", "Завдання 2: склад пакетів проживання");

        ServicePackage kidsClub = new ServicePackage("Дитячий клуб");
        kidsClub.add(new Service("Заняття", 1800));
        kidsClub.add(new Service("Екскурсія", 900));

        ServicePackage familyWeek = new ServicePackage("Сімейний тиждень");
        familyWeek.add(new Service("Проживання", 12000));
        familyWeek.add(new Service("Харчування", 5600));
        familyWeek.add(kidsClub);

        familyWeek.printTree("");

        printSummary(familyWeek);
        printSummary(kidsClub);
    }

    private static void printSummary(PackageComponent component) {
        Logger.log("Main", "«" + component.getName() + "»: вартість "
                + component.getPrice() + " грн, послуги: " + component.getServices());
    }

    public static void task3 () {
        IDevice conditioner = new AirConditioner();
        IDevice curtains = new Curtains();
        IDevice heatedFloor = new HeatedFloor();

        MobileApp mobileApp = new MobileApp(conditioner);
        WallPanel wallPanel = new WallPanel(conditioner);
        RemoteControl remote= new RemoteControl(curtains);


        log("WallPanel", "sends command ON to AirConditioner");
        log("AirConditioner", wallPanel.turnOn());
        log("MobileApp", "sends command ON to AirConditioner");
        log("AirConditioner", mobileApp.turnOn());

        log("RemoteControl", "sends command ON to Curtains");
        log("Curtains", remote.turnOn());

        mobileApp.setDevice(heatedFloor);
        log("MobileApp", "connected to HeatedFloor");
        log("MobileApp", "sends command ON to HeatedFloor");
        log("HeatedFloor", mobileApp.turnOn());

        remote.setDevice(conditioner);
        log("RemoteControl", "connected to AirConditioner");
        log("RemoteControl", "sends command OFF to AirConditioner");
        log("AirConditioner", remote.turnOff());

    }
}
