package task1;

import task3.Logger;

public class NeedsCleaningState implements RoomState {

    @Override
    public void book(Room room) {
        Logger.log("NeedsCleaningState", "Відмова: номер потребує прибирання");
    }

    @Override
    public void checkIn(Room room) {
        Logger.log("NeedsCleaningState", "Відмова: номер не прибраний");
    }

    @Override
    public void checkOut(Room room) {
        Logger.log("NeedsCleaningState", "Відмова: номер уже не зайнятий");
    }

    @Override
    public void repair(Room room) {
        Logger.log("NeedsCleaningState", "Номер переведено на ремонт");
        room.setState(new RepairState());
    }

    @Override
    public void clean(Room room) {
        Logger.log("NeedsCleaningState", "Номер прибрано");
        room.setState(new FreeCleanState());
    }
}