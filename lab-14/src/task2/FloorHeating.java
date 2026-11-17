package task2;

public class FloorHeating extends Device {
    public FloorHeating() { super("Тепла підлога"); }

    public void turnOff() { Log.log(name, "вимкнено"); }
}
