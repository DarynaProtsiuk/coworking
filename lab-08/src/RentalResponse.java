
public class RentalResponse {
    private final int id;
    private final String clientName;
    private final String vehicleModel;
    private final double rentalTotal;
    private final double insuranceTotal;
    private final double deposit;
    private final double finalPrice;

    public RentalResponse(int id, String clientName,
                          String vehicleModel, double rentalTotal,
                          double insuranceTotal, double deposit,
                          double finalPrice) {
        this.id = id;
        this.clientName = clientName;
        this.vehicleModel = vehicleModel;
        this.rentalTotal = rentalTotal;
        this.insuranceTotal = insuranceTotal;
        this.deposit = deposit;
        this.finalPrice = finalPrice;
    }

    public static RentalResponse from(RentalAgreement agreement) {
        return new RentalResponse(
                agreement.getId(),
                agreement.getClientName(),
                agreement.getVehicleModel(),
                agreement.calculateRentalTotal(),
                agreement.calculateInsuranceTotal(),
                agreement.calculateDepositAmount(),
                agreement.calculateFinalPrice()
        );
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public double getRentalTotal() {
        return rentalTotal;
    }

    public double getInsuranceTotal() {
        return insuranceTotal;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getFinalPrice() {
        return finalPrice;
    }
}
