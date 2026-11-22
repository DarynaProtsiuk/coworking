package task2;

public class Room {

    private final String number;
    private final RoomCategory category;
    private final RoomStatus status;
    private final String location;

    public Room(String number, RoomCategory category, RoomStatus status, String location) {
        this.number = number;
        this.category = category;
        this.status = status;
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public RoomCategory getCategory() {
        return category;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public String describe() {
        return "№" + number + " (" + category.getTitle() + ", " + status.getTitle() + "), " + location;
    }
}
