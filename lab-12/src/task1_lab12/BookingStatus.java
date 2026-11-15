package task1_lab12;

public enum BookingStatus {
    FREE("вільний"),
    BOOKED("заброньований"),
    OCCUPIED("зайнятий");

    private final String label;

    BookingStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}