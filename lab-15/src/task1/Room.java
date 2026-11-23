package task1;

public class Room {
    private RoomState state;

    public Room(RoomState state) {
        this.state = state;
    }

    public void setState(RoomState state) {
        this.state = state;
    }

    public void book() {
        state.book(this);
    }

    public void checkIn() {
        state.checkIn(this);
    }

    public void checkOut() {
        state.checkOut(this);
    }

    public void repair() {
        state.repair(this);
    }

    public void clean() {
        state.clean(this);
    }
}