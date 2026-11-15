package task3;

public class Lighting  implements IDevice {
    @Override
    public String turnOn(){
       return ("Turning lighting...");
    }

    @Override
    public String turnOff(){
        return ("Turning off lighting...");
    }
}
