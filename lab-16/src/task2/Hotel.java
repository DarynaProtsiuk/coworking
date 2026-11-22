package task2;

import task1.Logger;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements RoomCollection {

    private final List<Building> buildings = new ArrayList<>();

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    private List<Room> collectAllRooms() {
        List<Room> result = new ArrayList<>();
        for (Building building : buildings) {
            result.addAll(building.getAllRooms());
        }
        return result;
    }

    @Override
    public RoomIterator createCleaningIterator() {
        return new CleaningRoomIterator(collectAllRooms());
    }

    @Override
    public RoomIterator createFreeRoomsIterator(RoomCategory category) {
        return new FreeRoomIterator(collectAllRooms(), category);
    }

    @Override
    public RoomIterator createBuildingIterator(String buildingName) {
        for (Building building : buildings) {
            if (building.getName().equals(buildingName)) {
                return new BuildingRoomIterator(building.getAllRooms());
            }
        }
        throw new IllegalArgumentException("Корпус не знайдено: " + buildingName);
    }

    public void logState(String stage) {
        List<Room> rooms = collectAllRooms();
        int needCleaning = 0;
        int free = 0;
        for (Room room : rooms) {
            if (room.getStatus() == RoomStatus.NEEDS_CLEANING) {
                needCleaning++;
            }
            if (room.getStatus() == RoomStatus.FREE) {
                free++;
            }
        }
        Logger.log("Готель", stage + ": корпусів " + buildings.size() + ", номерів " + rooms.size()
                + ", потребують прибирання " + needCleaning + ", вільних " + free);
    }
}
