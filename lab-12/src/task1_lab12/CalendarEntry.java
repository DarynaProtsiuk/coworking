package task1_lab12;

import java.time.LocalDate;

public class CalendarEntry {
    private final int roomNumber;
    private final LocalDate date;
    private BookingStatus status;
    private final RoomType type; // посилання на спільний об'єкт

    public CalendarEntry(int roomNumber, LocalDate date, BookingStatus status, RoomType type) {
        this.roomNumber = roomNumber;
        this.date = date;
        this.status = status;
        this.type = type;
    }

    public int getRoomNumber() { return roomNumber; }
    public LocalDate getDate() { return date; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public RoomType getType() { return type; }

    public String describe() {
        return "номер " + roomNumber + ", " + date + ", " + status.getLabel() + ", категорія: " + type;
    }
}
