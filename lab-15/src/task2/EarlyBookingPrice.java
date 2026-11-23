package task2;
import task3.Logger;

public class EarlyBookingPrice implements PriceStrategy {

    @Override
    public double calculatePrice(double pricePerNight, int nights) {
        double total = pricePerNight * nights * 0.85;

        Logger.log("EarlyBookingPrice", "Застосовано знижку раннього бронювання 15%");

        return total;
    }
}