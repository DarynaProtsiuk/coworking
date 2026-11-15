package task3;

public class Lighting  implements IDevice {
    @Override
    public void turnOn(){
        System.out.println("Turning lighting...");
    }

    @Override
    public void turnOff(){
        System.out.println("Turning off lighting...");
    }
}
