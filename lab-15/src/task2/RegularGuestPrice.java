package task2;
import task3.Logger;

public class RegularGuestPrice implements PriceStrategy {

    @Override
    public double calculatePrice(double pricePerNight, int nights) {
        double total = pricePerNight * nights * 0.9;

        Logger.log("RegularGuestPrice", "Застосовано знижку постійного гостя 10%");

        return total;
    }
}