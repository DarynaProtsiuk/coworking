package task2;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShippingCostCalculator {

    public BigDecimal calculateCost(Parcel parcel, ShippingCostStrategy strategy) {

        BigDecimal cost = strategy.calculateCost(parcel);

        cost = cost.setScale(2, RoundingMode.HALF_UP);

        System.out.println(
                "[SHIPPING] Parcel " + parcel.getTrackingNumber()
                        + " ("
                        + strategy.getClass().getSimpleName()
                        + "): Weight=" + parcel.getWeightKg()
                        + " kg, Distance=" + parcel.getDistanceKm()
                        + " km -> Cost: $" + cost
        );

        return cost;
    }
}