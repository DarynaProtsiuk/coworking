package task2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Guest guest1 = new Guest("Guest1", "LastName Guest1");
        LocalDate arriveDate = LocalDate.of(2025, 3, 10);
        BookingBuilder builder = new BookingBuilder();
        builder.setGuest(guest1) .setArriveDate(arriveDate)
                .setDepartureDate(arriveDate.plusDays(5))
                .setRoomCategory(RoomCategory.LUXURY) .setBreakfast(true)
                .setTransfer(true) .setChildBed(true);
        Booking booking = builder.build();

        System.out.println(booking.getGuest());
        System.out.println(booking.getRoomCategory());
        System.out.println(booking.isBreakfast());

        System.out.println();

        Guest guest2 =new Guest("Guest2", "LastName Guest2");
        BookingDirector director = new BookingDirector();
        Booking booking2 = director.createSkiWeek(guest2, LocalDate.of(2025, 3, 10));
        System.out.println(booking2.getGuest());
        System.out.println(booking2.getRoomCategory());
        System.out.println(booking2.isBreakfast());

        System.out.println();

        Guest guest3 =new Guest("Guest3", "LastName Guest3");
        Booking booking3 = director.createWeekend(guest3, LocalDate.of(2025, 3, 10));
        System.out.println(booking3.getGuest());
        System.out.println(booking3.getRoomCategory());
        System.out.println(booking3.isBreakfast());

    }
}
