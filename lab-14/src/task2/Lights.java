package task2;

public class Lights extends Device {
    public Lights() { super("Освітлення"); }

    public void turnOn()    { Log.log(name, "основне світло увімкнено"); }
    public void turnOff()   { Log.log(name, "світло вимкнено"); }
    public void nightMode() { Log.log(name, "увімкнено нічне освітлення"); }
}
