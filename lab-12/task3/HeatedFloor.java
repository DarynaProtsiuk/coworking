package task3;

public class HeatedFloor implements IDevice {
    @Override
    public void turnOn(){
        System.out.println("Turning heated floor ...");
    }

    @Override
    public void turnOff(){
        System.out.println("Turning off heated floor...");
    }
}
