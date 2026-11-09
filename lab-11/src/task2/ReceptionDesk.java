package task2;

public class ReceptionDesk {
    private final CheckInFacade facade;

    public ReceptionDesk(CheckInFacade facade) {
        this.facade = facade;
    }

    public void checkInGuest(String guestName, String bookingId) {
        Log.write("ReceptionDesk", "адміністратор заселяє гостя " + guestName);
        facade.checkIn(guestName, bookingId);
    }
}