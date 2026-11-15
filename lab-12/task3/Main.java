package task3;

public class Main {
    public static void main(String[] args) {
        AirConditioner conditioner = new AirConditioner();
        Curtains curtains = new Curtains();
        HeatedFloor heatedFloor = new HeatedFloor();

        MobileApp mobileAppConditioner = new MobileApp(conditioner);

        mobileAppConditioner.turnOn();
        mobileAppConditioner.turnOff();

        WallPanel wallPanelConditioner = new WallPanel(conditioner);

        RemoteControl remoteControlCurtains = new RemoteControl(curtains);

        MobileApp mobileAppHeatedFloor = new MobileApp(heatedFloor);

        wallPanelConditioner.turnOn();
        remoteControlCurtains.turnOn();
        mobileAppHeatedFloor.turnOn();
    }
}
