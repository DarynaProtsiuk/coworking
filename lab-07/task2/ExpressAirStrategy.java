package task2;

import java.math.BigDecimal;

public class ExpressAirStrategy implements ShippingCostStrategy {
    // $25 базово + $4.00 за кг (або $15 за м³ залежно що більше) + $0.50 за км

    @Override
    public BigDecimal calculateCost(Parcel parcel) {
        BigDecimal weightFee = parcel.getWeightKg().multiply(new BigDecimal("4.00"));
        BigDecimal volumeFee = parcel.getVolumeM3().multiply(new BigDecimal("15.00"));
        BigDecimal highestFee = weightFee.compareTo(volumeFee) > 0 ? weightFee : volumeFee;
        return new BigDecimal("25.00")
                .add(highestFee)
                .add(parcel.getDistanceKm().multiply(new BigDecimal("0.50")));
    }
}
