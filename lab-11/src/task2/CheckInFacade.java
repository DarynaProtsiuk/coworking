package task2;

public class CheckInFacade {
    private final BookingVerificationService bookingVerification = new BookingVerificationService();
    private final GuestRegistrationService guestRegistration = new GuestRegistrationService();
    private final RoomAssignmentService roomAssignment = new RoomAssignmentService();
    private final KeyCardService keyCard = new KeyCardService();
    private final BillingService billing = new BillingService();
    private final HousekeepingService housekeeping = new HousekeepingService();

    // Єдине місце, де описано порядок заселення
    public int checkIn(String guestName, String bookingId) {
        Log.write("CheckInFacade", "початок заселення гостя " + guestName);

        if (!bookingVerification.verify(bookingId)) {
            Log.write("CheckInFacade", "заселення перервано: бронювання не підтверджено");
            return -1;
        }
        guestRegistration.register(guestName);
        int room = roomAssignment.assign(guestName);
        keyCard.issue(guestName, room);
        billing.openAccount(guestName, room);
        housekeeping.notifyRoomOccupied(room);

        Log.write("CheckInFacade", "заселення завершено, номер " + room);
        return room;
    }

    // Підсистема доступна окремо
    public KeyCardService getKeyCardService() {
        return keyCard;
    }
}