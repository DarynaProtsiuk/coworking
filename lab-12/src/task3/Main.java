package task3;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        task3();
    }

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static LocalTime time = LocalTime.of(8, 0, 0); // умовний час


    public static void log(String source, String event) {
        System.out.println("[" + time.format(FORMAT) + "] [" + source + "] " + event);
        time = time.plusSeconds(1);
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
