package task2;
import java.math.BigDecimal;

class Parcel {
    private String trackingNumber;
    private BigDecimal weightKg;
    private BigDecimal volumeM3;
    private BigDecimal distanceKm;

    public Parcel(String trackingNumber, BigDecimal weightKg, BigDecimal volumeM3, BigDecimal distanceKm) {
        this.trackingNumber = trackingNumber;
        this.weightKg = weightKg;
        this.volumeM3 = volumeM3;
        this.distanceKm = distanceKm;
    }

    public String getTrackingNumber() { return trackingNumber; }
    public BigDecimal getWeightKg() { return weightKg; }
    public BigDecimal getVolumeM3() { return volumeM3; }
    public BigDecimal getDistanceKm() { return distanceKm; }
}