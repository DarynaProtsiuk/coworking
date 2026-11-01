public class EconomyRentalCost implements RentalCostPolicy {
    @Override
    public double calculateRentalCost (double dailyRate, int days) {
        return dailyRate * days;
    }
}
