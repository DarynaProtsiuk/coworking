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
        setUp();
        scenarioWindowOpened();
        scenarioGuestLeaves();
        scenarioEvening();
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
