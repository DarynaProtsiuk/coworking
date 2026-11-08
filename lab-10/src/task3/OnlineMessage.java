package task3;

public class OnlineMessage implements Confirmation{
    private final String guest;
    private final String room;

    public OnlineMessage(String guest, String room) {
        this.guest = guest;
        this.room = room;
    }
    @Override
    public String getMessage() {
        return "Dear guest: " + guest
                + " our team want to confirm your successful booking of the room number: \""
                + room + "\" in the hotel \"Карпатьські вершини\".";
    }
}
