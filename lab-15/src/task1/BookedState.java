package task1;

import task3.Logger;

public class BookedState implements RoomState {

    @Override
    public void book(Room room) {
        Logger.log("BookedState", "Відмова: номер уже заброньований");
    }

    @Override
    public void checkIn(Room room) {
        Logger.log("BookedState", "Гостя заселено");
        room.setState(new OccupiedState());
    }

    @Override
    public void checkOut(Room room) {
        Logger.log("BookedState", "Відмова: номер ще не зайнятий");
    }

    @Override
    public void repair(Room room) {
        Logger.log("BookedState", "Бронювання скасовано. Номер переведено на ремонт");
        room.setState(new RepairState());
    }

    @Override
    public void clean(Room room) {
        Logger.log("BookedState", "Відмова: номер уже прибраний");
    }
}