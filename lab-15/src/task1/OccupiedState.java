package task1;

import task3.Logger;

public class OccupiedState implements RoomState {

    @Override
    public void book(Room room) {
        Logger.log("OccupiedState", "Відмова: номер зайнятий");
    }

    @Override
    public void checkIn(Room room) {
        Logger.log("OccupiedState", "Відмова: у номері вже є гість");
    }

    @Override
    public void checkOut(Room room) {
        Logger.log("OccupiedState", "Гість виїхав. Номер потребує прибирання");
        room.setState(new NeedsCleaningState());
    }

    @Override
    public void repair(Room room) {
        Logger.log("OccupiedState", "Відмова: не можна ремонтувати зайнятий номер");
    }

    @Override
    public void clean(Room room) {
        Logger.log("OccupiedState", "Відмова: номер зайнятий");
    }
}