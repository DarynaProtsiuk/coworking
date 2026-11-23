package task1;

import task3.Logger;

public class FreeCleanState implements RoomState {

    @Override
    public void book(Room room) {
        Logger.log("FreeCleanState", "Номер заброньовано");
        room.setState(new BookedState());
    }

    @Override
    public void checkIn(Room room) {
        Logger.log("FreeCleanState", "Гостя заселено");
        room.setState(new OccupiedState());
    }

    @Override
    public void checkOut(Room room) {
        Logger.log("FreeCleanState", "Відмова: номер уже вільний");
    }

    @Override
    public void repair(Room room) {
        Logger.log("FreeCleanState", "Номер переведено на ремонт");
        room.setState(new RepairState());
    }

    @Override
    public void clean(Room room) {
        Logger.log("FreeCleanState", "Відмова: номер уже прибраний");
    }
}