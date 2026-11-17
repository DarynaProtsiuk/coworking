package task2;

public class TimeSensor extends Device {
    public TimeSensor() { super("Годинник"); }

    public void eveningComes() {
        Log.log(name, "настав вечір");
        mediator.notify(this, RoomEvent.EVENING_CAME);
    }
}