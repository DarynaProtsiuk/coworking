package task2;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private final String name;
    private final List<Floor> floors = new ArrayList<>();
    private final List<Room> detachedRooms = new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public void addDetachedRoom(Room room) {
        detachedRooms.add(room);
    }

    public List<Room> getAllRooms() {
        List<Room> result = new ArrayList<>();
        for (Floor floor : floors) {
            result.addAll(floor.getRooms());
        }
        result.addAll(detachedRooms);
        return result;
    }
}