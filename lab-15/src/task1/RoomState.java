package task1;

public interface RoomState {
    public void book(Room room);
    public void checkIn(Room room);
    public void checkOut(Room room);
    public void repair(Room room);
    public void clean(Room room);
}
