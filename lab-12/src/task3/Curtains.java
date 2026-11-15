package task3;

public class Curtains  implements IDevice {
    @Override
    public String turnOn(){
        return ("Curtains are closed");
    }

    @Override
    public String turnOff(){
        return ("Curtains are open");
    }
}
