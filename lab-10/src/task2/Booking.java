package task2;

import java.time.LocalDate;

public class Booking {
    private final Guest guest;
    private final LocalDate arriveDate;
    private final LocalDate departureDate;
    private final RoomCategory roomCategory;
    private final boolean breakfast;
    private final boolean transfer;
    private final boolean lateCheckout;
    private final boolean childBed;
    private final String comment;


   Booking(Guest guest, LocalDate arriveDate, LocalDate departureDate, RoomCategory roomCategory, boolean breakfast, boolean transfer, boolean lateCheckout, boolean childBed, String comment) {
        this.guest = guest;
        this.arriveDate = arriveDate;
        this.departureDate = departureDate;
        this.roomCategory = roomCategory;
        this.breakfast = breakfast;
        this.transfer = transfer;
        this.lateCheckout = lateCheckout;
        this.childBed = childBed;
        this.comment = comment;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getArriveDate() {
        return arriveDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public boolean isLateCheckout() {
        return lateCheckout;
    }

    public boolean isChildBed() {
        return childBed;
    }

    public String getComment() {
        return comment;
    }
}
