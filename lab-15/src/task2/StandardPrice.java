package task2;

import task3.Logger;

public class StandardPrice implements PriceStrategy {

    @Override
    public double calculatePrice(double pricePerNight, int nights) {
        double total = pricePerNight * nights;

        Logger.log("StandardPrice", "Розрахунок за стандартним тарифом");

        return total;
    }
}