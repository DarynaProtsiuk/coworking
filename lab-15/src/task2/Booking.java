package task2;

public class Booking {
    private double pricePerNight;
    private int nights;
    private PriceStrategy strategy;

    public Booking(double pricePerNight, int nights,
                   PriceStrategy strategy) {
        this.pricePerNight = pricePerNight;
        this.nights = nights;
        this.strategy = strategy;
    }

    public void setStrategy(PriceStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice() {
        return strategy.calculatePrice(pricePerNight, nights);
    }
}