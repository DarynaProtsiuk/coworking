package task3;

public class AirConditioner implements IDevice {
    @Override
    public void turnOn(){
        System.out.println("Turning air conditioner...");
    }

    @Override
    public void turnOff(){
        System.out.println("Turning off air conditioner...");
    }
}
