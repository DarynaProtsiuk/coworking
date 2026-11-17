package task1;

public class CheckOutEvent {
    private final int roomNumber;
    private final String guestName;
    private final boolean leftReview;

    public CheckOutEvent(int roomNumber, String guestName, boolean leftReview) {
        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.leftReview = leftReview;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getGuestName() { return guestName; }
    public boolean hasLeftReview() { return leftReview; }
}
