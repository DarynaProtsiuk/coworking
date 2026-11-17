package task2;

public class WindowSensor extends Device {
    public WindowSensor() { super("Датчик вікна"); }

    public void open() {
        Log.log(name, "вікно відчинено");
        mediator.notify(this, RoomEvent.WINDOW_OPENED);
    }

    public void close() {
        Log.log(name, "вікно зачинено");
        mediator.notify(this, RoomEvent.WINDOW_CLOSED);
    }
}
