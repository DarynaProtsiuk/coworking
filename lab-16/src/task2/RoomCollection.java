package task2;

public interface RoomCollection {
    // різні методи обходу
    RoomIterator createCleaningIterator(); // метод-фабрика ітератора
    RoomIterator createFreeRoomsIterator(RoomCategory category);
    RoomIterator createBuildingIterator(String buildingName);
}
