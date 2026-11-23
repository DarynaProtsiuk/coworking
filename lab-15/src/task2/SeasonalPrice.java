package task2;

import task3.Logger;

public class SeasonalPrice implements PriceStrategy {

    @Override
    public double calculatePrice(double pricePerNight, int nights) {
        double total = pricePerNight * nights * 1.3;

        Logger.log("SeasonalPrice", "Застосовано сезонне підвищення ціни на 30%");

        return total;
    }
}
