package task2;
import java.math.BigDecimal;

public class StandardCourierStrategy implements ShippingCostStrategy{
    @Override
    public BigDecimal calculateCost(Parcel parcel){
        return  new BigDecimal("5.00")
                .add(parcel.getWeightKg().multiply(new BigDecimal("1.50")))
                .add(parcel.getDistanceKm().multiply(new BigDecimal("0.10")));
    }
}
