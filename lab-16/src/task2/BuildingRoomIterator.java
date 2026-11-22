package task2;

import java.util.List;

public class BuildingRoomIterator extends FilteringRoomIterator {

    public BuildingRoomIterator(List<Room> rooms) {
        super(rooms);
    }

    @Override
    protected boolean matches(Room room) {
        return true;
    }
}
