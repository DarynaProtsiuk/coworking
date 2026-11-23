package task1;

import task3.Logger;

public class RepairState implements RoomState {

    @Override
    public void book(Room room) {
        Logger.log("RepairState", "Відмова: номер на ремонті");
    }

    @Override
    public void checkIn(Room room) {
        Logger.log("RepairState", "Відмова: номер на ремонті");
    }

    @Override
    public void checkOut(Room room) {
        Logger.log("RepairState", "Відмова: номер не зайнятий");
    }

    @Override
    public void repair(Room room) {
        Logger.log("RepairState", "Номер уже на ремонті");
    }

    @Override
    public void clean(Room room) {
        Logger.log("RepairState", "Відмова: спочатку необхідно завершити ремонт");
    }
}