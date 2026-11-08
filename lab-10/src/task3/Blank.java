package task3;

public class Blank implements Confirmation {
    private final String guest;
    private final String room;

    public Blank(String guest, String room) {
        this.guest = guest;
        this.room = room;
    }

    @Override
    public String getMessage() {
        return "Confirmation of the booking!\n"
                + "Guest: " + guest + "\n"
                + "Room number: " + room + "\n"
                + "Sign og the administrator: ______";

    }
}
