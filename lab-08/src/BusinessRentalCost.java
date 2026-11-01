public class BusinessRentalCost implements RentalCostPolicy {
    @Override
    public double calculateRentalCost (double dailyRate, int days) {
        return dailyRate * days * 1.3;
    }
}
