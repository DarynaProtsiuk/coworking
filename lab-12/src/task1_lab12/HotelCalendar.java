package task1_lab12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelCalendar {
    private final List<CalendarEntry> entries = new ArrayList<>();
    private int nights;

    public void build(int rooms, int nights, LocalDate startDate) {
        this.nights = nights;
        for (int room = 1; room <= rooms; room++) {
            RoomType type = RoomTypeFactory.getRoomType(categoryFor(room));
            for (int night = 0; night < nights; night++) {
                BookingStatus status = BookingStatus.FREE;
                if ((room + night) % 11 == 0) status = BookingStatus.OCCUPIED;
                else if ((room + night) % 7 == 0) status = BookingStatus.BOOKED;
                entries.add(new CalendarEntry(room, startDate.plusDays(night), status, type));
            }
        }
        Logger.log("HotelCalendar", "створено записів: " + entries.size());
    }

    // запис потрібної кімнати на потрібну ніч (кімнати рахуємо з 1, ночі з 0)
    public CalendarEntry getEntry(int room, int night) {
        return entries.get((room - 1) * nights + night);
    }

    public int size() {
        return entries.size();
    }

    private String categoryFor(int room) {
        if (room <= 15) return "Стандарт";
        if (room <= 30) return "Комфорт";
        if (room <= 45) return "Сімейний";
        return "Люкс";
    }
}