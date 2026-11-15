package task3;

abstract class ControlDevice {
    private IDevice device;

    public ControlDevice(IDevice device) {
        this.device = device;
    }

    public void turnOn(){
        device.turnOn();
    }

    public void turnOff(){
        device.turnOff();
    }
}
