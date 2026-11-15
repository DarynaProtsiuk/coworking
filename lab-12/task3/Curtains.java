package task3;

public class Curtains  implements IDevice {
    @Override
    public void turnOn(){
        System.out.println("Turning curtains...");
    }

    @Override
    public void turnOff(){
        System.out.println("Turning off curtains...");
    }
}
