package task2;
import java.math.BigDecimal;

public interface ShippingCostStrategy {
    BigDecimal calculateCost(Parcel parcel);
}
