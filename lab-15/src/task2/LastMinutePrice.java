package task2;
import task3.Logger;

public class LastMinutePrice implements PriceStrategy {

    @Override
    public double calculatePrice(double pricePerNight, int nights) {
        double total = pricePerNight * nights * 0.8;

        Logger.log("LastMinutePrice", "Застосовано знижку останніх хвилин 20%");

        return total;
    }
}