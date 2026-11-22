package task2;

public enum RoomStatus {
    FREE("вільний"),
    OCCUPIED("зайнятий"),
    NEEDS_CLEANING("потребує прибирання");

    private final String title;

    RoomStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}