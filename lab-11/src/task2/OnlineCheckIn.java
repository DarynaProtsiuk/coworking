package task2;

public class OnlineCheckIn {
    private final CheckInFacade facade;

    public OnlineCheckIn(CheckInFacade facade) {
        this.facade = facade;
    }

    public void checkInGuest(String guestName, String bookingId) {
        Log.write("OnlineCheckIn", "гість " + guestName + " заселяється онлайн");
        facade.checkIn(guestName, bookingId);
    }
}