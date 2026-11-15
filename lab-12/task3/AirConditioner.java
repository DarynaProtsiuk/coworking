package task3;

public class AirConditioner implements IDevice {
    @Override
    public String turnOn(){
       return ("Turning air conditioner...");
    }

    @Override
    public String turnOff(){
        return ("Turning off air conditioner...");
    }
}
