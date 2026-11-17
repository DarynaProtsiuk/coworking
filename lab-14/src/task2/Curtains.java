package task2;

public class Curtains extends Device {
    public Curtains() { super("Штори"); }

    public void close() { Log.log(name, "штори закрито"); }
}
