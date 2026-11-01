public class RentalAgreement {
    private final int id;
    private final Client client;
    private final Vehicle vehicle;
    private final int days;
    private final InsuranceTotalPolicy insurancePolicy;
    private String status;

    private RentalAgreement(int id, Client client, Vehicle vehicle, int days, InsuranceTotalPolicy insurancePolicy) {
        this.vehicle = vehicle;
        this.status = "New";
        this.insurancePolicy = insurancePolicy;
        this.id = id;
        this.days = days;
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public static RentalAgreement create(int id, Client client, Vehicle vehicle, int days, String insuranceType) {
        if (client == null) {
            throw new IllegalArgumentException("Клієнт обов'язковий");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Авто обов'язкове");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Кількість днів має бути більшою за нуль");
        }
        InsuranceTotalPolicy policy = InsurancePolicyFactory.forType(insuranceType);
        return new RentalAgreement(id, client, vehicle, days, policy);
    }

    public double calculateInsuranceTotal() {
        return insurancePolicy.calculateInsuranceTotal(days);
    }

    public double calculateRentalTotal(){
        return vehicle.calculateRentalCost(days);
    }

    public double calculateDepositAmount(){
        return client.calculateDeposit();
    }

    public double calculateFinalPrice() {
        return calculateRentalTotal() + calculateInsuranceTotal();
    }

    public void approve(){
        this.status = "Approved";
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return client.getName();
    }

    public String getClientPhone() {
        return client.getPhone();
    }

    public String getVehicleModel() {
        return vehicle.getModel();
    }
}