package task2;
import java.time.LocalDate;

public class BookingDirector {
    public Booking createWeekend(Guest guest, LocalDate arriveDate) {
        return new BookingBuilder().setGuest(guest) .setArriveDate(arriveDate) .setDepartureDate(arriveDate.plusDays(2)) .setRoomCategory(RoomCategory.COMFORT) .build();
    }

    public Booking createSkiWeek(Guest guest, LocalDate arriveDate) {
        return new BookingBuilder().setGuest(guest) .setArriveDate(arriveDate) .setDepartureDate(arriveDate.plusDays(7)) .setRoomCategory(RoomCategory.LUXURY) .setBreakfast(true) .setTransfer(true) .build();
    }
}
