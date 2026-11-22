package task2;

import java.util.List;
import java.util.NoSuchElementException;

//основа ітераторів
public abstract class FilteringRoomIterator implements RoomIterator {

    private final List<Room> rooms;
    private int position = 0; //забезпечує незалежність обходів

    protected FilteringRoomIterator(List<Room> rooms) {
        this.rooms = rooms;
    }

    protected abstract boolean matches(Room room);

    @Override
    public boolean hasNext() {
        skipToNextMatch();
        return position < rooms.size();
    }

    @Override
    public Room next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Номерів більше немає");
        }
        Room room = rooms.get(position);
        position++;
        return room;
    }

    private void skipToNextMatch() {
        while (position < rooms.size() && !matches(rooms.get(position))) {
            position++;
        }
    }
}
