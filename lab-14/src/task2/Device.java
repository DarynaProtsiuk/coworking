package task2;

public abstract class Device {
    protected final String name;
    protected RoomMediator mediator;

    protected Device(String name) {
        this.name = name;
    }

    public void setMediator(RoomMediator mediator) { this.mediator = mediator; }
    public String getName() { return name; }
}
