package task2;

import java.util.List;

public class CleaningRoomIterator extends FilteringRoomIterator {

    public CleaningRoomIterator(List<Room> rooms) {
        super(rooms);
    }

    @Override
    protected boolean matches(Room room) {
        return room.getStatus() == RoomStatus.NEEDS_CLEANING;
    }
}
