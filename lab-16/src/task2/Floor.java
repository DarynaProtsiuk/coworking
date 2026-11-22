package task2;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final int number;
    private final List<Room> rooms = new ArrayList<>();

    public Floor(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}