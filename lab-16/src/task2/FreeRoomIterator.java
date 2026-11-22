package task2;

import java.util.List;

public class FreeRoomIterator extends FilteringRoomIterator {

    private final RoomCategory category;

    public FreeRoomIterator(List<Room> rooms, RoomCategory category) {
        super(rooms);
        this.category = category;
    }

    @Override
    protected boolean matches(Room room) {
        return room.getStatus() == RoomStatus.FREE && room.getCategory() == category;
    }
}
