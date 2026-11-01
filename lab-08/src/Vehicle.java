public class Vehicle {
    private final int id;
    private final  String model;
    private final RentalCostPolicy costPolicy;
    private final double dailyRate;

    private Vehicle(int id, String model, RentalCostPolicy costPolicy, double dailyRate) {
        this.costPolicy = costPolicy;
        this.id = id;
        this.model = model;
        this.dailyRate = dailyRate;
    }

    public static Vehicle create(int id, String model, String classType, double dailyRate) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Модель авто не може бути порожньою");
        }
        if (!"Economy".equalsIgnoreCase(classType)
                && !"Business".equalsIgnoreCase(classType)
                && !"SUV".equalsIgnoreCase(classType)) {
            throw new IllegalArgumentException("Невідомий клас авто: " + classType);
        }
        if (dailyRate <= 0) {
            throw new IllegalArgumentException("Добова ставка має бути додатною");
        }
        RentalCostPolicy policy = RentalCostPolicyFactory.forClass(classType);
        return new Vehicle(id, model, policy, dailyRate);
    }

    public String getModel() {
        return model;
    }

    public double calculateRentalCost(int days) {
        return costPolicy.calculateRentalCost(dailyRate, days);
    }
}