
public class RentalRequest {
    private final String name;
    private final int driverExperienceYears;
    private final String phone;
    private final String vehicleModel;
    private final String carClass;
    private final double dailyRate;
    private final int rentalDays;
    private final String insuranceType;

    public RentalRequest(String name, int driverExperienceYears,
                         String phone, String vehicleModel,
                         String carClass, double dailyRate,
                         int rentalDays, String insuranceType) {
        this.name = name;
        this.driverExperienceYears = driverExperienceYears;
        this.phone = phone;
        this.vehicleModel = vehicleModel;
        this.carClass = carClass;
        this.dailyRate = dailyRate;
        this.rentalDays = rentalDays;
        this.insuranceType = insuranceType;
    }

    public String getName() {
        return name;
    }

    public int getDriverExperienceYears() {
        return driverExperienceYears;
    }

    public String getPhone() {
        return phone;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getCarClass() {
        return carClass;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public String getInsuranceType() {
        return insuranceType;
    }
}
