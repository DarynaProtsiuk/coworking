package task3;

public class File implements Confirmation {
    private final String guest;
    private final String room;

    public File(String guest, String room) {
        this.guest = guest;
        this.room = room;
    }
    @Override
    public String getMessage() {
        return "Booking: guest = " + guest + "; room = " + room + "; status = confirmed.";
    }
}
