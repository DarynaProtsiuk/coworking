package task2;

public class AirConditioner extends Device {
    private boolean on;

    public AirConditioner() { super("Кондиціонер"); }

    public void turnOn() {
        on = true;
        Log.log(name, "увімкнено");
    }

    public void turnOff() {
        if (!on) { Log.log(name, "вже вимкнений, нічого не роблю"); return; }
        on = false;
        Log.log(name, "вимкнено");
    }
}