package task1;

public class AccommodationCharge implements Charge{
    private final String roomCategory;
    private final int nights;
    private final double ratePerNight;

    public AccommodationCharge(String roomCategory, int nights, double ratePerNight) {
        this.roomCategory = roomCategory;
        this.nights = nights;
        this.ratePerNight = ratePerNight;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String getTitle() {
        return "Проживання (" + roomCategory + ", " + nights + " ночей)";
    }

    @Override
    public double getAmount() {
        return nights * ratePerNight;
    }

    @Override
    public void accept(ChargeVisitor visitor) {
        visitor.visit(this);
    }
}
