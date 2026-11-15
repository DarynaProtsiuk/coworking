package task3;

public class HeatedFloor implements IDevice {
    @Override
    public String turnOn(){
        return ("Turning heated floor ...");
    }

    @Override
    public String turnOff(){
        return ("Turning off heated floor...");
    }
}
