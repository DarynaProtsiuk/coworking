package task2;

public class RoomAssignmentService {
    public int assign(String guestName) {
        int room = 305;
        Log.write("RoomAssignment", "гостю " + guestName + " призначено номер " + room);
        return room;
    }
}
