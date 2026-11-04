public class KeyCard {
    private final String id;
    private String roomNumber;
    private String validUntil;
    private int issueCount;

    public KeyCard(String id) {
        this.id = id;
        HotelLog.log("Виробництво", "Виготовлення карти " + id + ": бланк, кодування, реєстрація в замках...");
        HotelLog.pause(300);
        HotelLog.log("Виробництво", "Карта " + id + " готова");
    }

    public void program(String roomNumber, String validUntil) {
        this.roomNumber = roomNumber;
        this.validUntil = validUntil;
        issueCount++;
    }

    public void reset() {
        roomNumber = null;
        validUntil = null;
    }

    public boolean opens(String room) {
        return roomNumber != null && roomNumber.equals(room);
    }

    public String getId() { return id; }
    public String getRoomNumber() { return roomNumber; }
    public int getIssueCount() { return issueCount; }
}