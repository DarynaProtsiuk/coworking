import task1.*;
import task2.*;

public class Main {
    private static WindowSensor window;
    private static PresenceSensor presence;
    private static TimeSensor clock;
    private static AirConditioner conditioner;
    private static Lights lights;
    private static Curtains curtains;
    private static FloorHeating floorHeating;
    private static SmartRoomMediator mediator;

    public static void main(String[] args) {
        runGuestCheckOut();
        setUp();
        scenarioWindowOpened();
        scenarioGuestLeaves();
        scenarioEvening();
    }

    private static void runGuestCheckOut() {
        Room room = new Room(101);

        HousekeepingService housekeeping = new HousekeepingService();
        AccountingService accounting = new AccountingService();
        KeyLockSystem locks = new KeyLockSystem();
        MarketingService marketing = new MarketingService();
        MinibarService minibar = new MinibarService();

        System.out.println("Крок 1: покоївки, бухгалтерія, замки");
        Logger.setTime("11:00");
        room.subscribe(housekeeping);
        room.subscribe(accounting);
        room.subscribe(locks);
        room.checkOut("Іван Петренко", false);

        System.out.println("\nКрок 2: підключаємо маркетинг (і мінібар), виїзд з відгуком");
        Logger.setTime("12:30");
        room.subscribe(marketing);
        room.subscribe(minibar);
        room.checkOut("Олена Коваль", true);

        System.out.println("\nКрок 3: ніч, покоївки відписуються");
        Logger.setTime("23:30");
        room.unsubscribe(housekeeping);
        room.checkOut("Андрій Мельник", false);
        System.out.println("==================================================");
    }

    private static void setUp() {
        mediator = new SmartRoomMediator();
        window = new WindowSensor();
        presence = new PresenceSensor();
        clock = new TimeSensor();
        conditioner = new AirConditioner();
        lights = new Lights();
        curtains = new Curtains();
        floorHeating = new FloorHeating();

        for (Device d : new Device[]{window, presence, clock, conditioner, lights, curtains, floorHeating}) {
            d.setMediator(mediator);
        }
        mediator.setConditioner(conditioner);
        mediator.setLights(lights);
        mediator.setCurtains(curtains);
        mediator.setFloorHeating(floorHeating);

        presence.guestEnters();
        conditioner.turnOn();
        lights.turnOn();
        System.out.println();
    }

    private static void scenarioWindowOpened() {
        System.out.println("Сценарій 1: гість відчиняє вікно ");
        window.open();
        System.out.println();
    }

    private static void scenarioGuestLeaves() {
        System.out.println("Сценарій 2: гість виходить з номера ");
        presence.guestLeaves();
        System.out.println();
    }

    private static void scenarioEvening() {
        System.out.println("Сценарій 3: настає вечір ");
        clock.eveningComes();
    }
}
