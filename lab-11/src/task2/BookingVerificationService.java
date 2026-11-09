package task2;

public class BookingVerificationService {
    public boolean verify(String bookingId) {
        Log.write("BookingVerification", "бронювання " + bookingId + " підтверджено");
        return true;
    }
}