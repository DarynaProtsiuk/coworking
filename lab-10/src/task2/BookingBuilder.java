package task2;
import java.time.LocalDate;



public class BookingBuilder {
    private  Guest guest;
    private  LocalDate arriveDate;
    private  LocalDate departureDate;
    private  RoomCategory roomCategory;

    private  boolean breakfast;
    private  boolean transfer;
    private  boolean lateCheckout;
    private  boolean childBed;
    private  String comment;

    public BookingBuilder setGuest(Guest guest) {
        this.guest = guest;
        return this;
    }

    public BookingBuilder setArriveDate(LocalDate arriveDate) {
       this.arriveDate = arriveDate;
       return this;
    }

    public BookingBuilder setDepartureDate(LocalDate departureDate){
        this.departureDate = departureDate;
        return this;
    }

    public BookingBuilder setRoomCategory(RoomCategory roomCategory){
        this.roomCategory = roomCategory;
        return this;
    }

    public BookingBuilder setBreakfast(boolean breakfast ){
        this.breakfast = breakfast;
        return this;
    }

    public BookingBuilder setTransfer(boolean transfer){
        this.transfer = transfer;
        return this;
    }

    public BookingBuilder setLateCheckout(boolean lateCheckout){
        this.lateCheckout = lateCheckout;
        return this;
    }

    public BookingBuilder setChildBed(boolean childBed){
        this.childBed = childBed;
        return this;
    }

    public BookingBuilder setComment(String comment){
        this.comment = comment;
        return this;
    }

    public Booking build(){
        if (guest == null) {
            throw new IllegalStateException("Гість не вказаний");
        }
        if (roomCategory == null) {
            throw new IllegalStateException("Категорія не вказана");
        }
        if (arriveDate == null || departureDate == null) {
            throw new IllegalStateException("Дата заїзду або виїзду не вказана");
        }
        if (!departureDate.isAfter(arriveDate)){
            throw new IllegalStateException("Неможливо сформувати бронювання: некоректні дати проживання");
        }

        return new Booking(guest, arriveDate, departureDate, roomCategory, breakfast, transfer, lateCheckout, childBed, comment);

    }
}
