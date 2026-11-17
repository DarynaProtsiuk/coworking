package task2;

public class PresenceSensor extends Device {
    public PresenceSensor() { super("Датчик присутності"); }

    public void guestEnters() {
        Log.log(name, "гість зайшов у номер");
        mediator.notify(this, RoomEvent.GUEST_ENTERED);
    }

    public void guestLeaves() {
        Log.log(name, "гість вийшов з номера");
        mediator.notify(this, RoomEvent.GUEST_LEFT);
    }
}