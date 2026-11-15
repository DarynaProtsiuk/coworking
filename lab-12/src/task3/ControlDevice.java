package task3;

public class ControlDevice {
    private IDevice device;

    public ControlDevice(IDevice device) {
        this.device = device;
    }

    public void setDevice(IDevice device) {
        this.device = device;
    }

    public String turnOn(){
        return device.turnOn();
    }

    public String turnOff(){
        return device.turnOff();
    }
}
