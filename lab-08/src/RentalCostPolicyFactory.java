public class RentalCostPolicyFactory {
    public static RentalCostPolicy forClass(String classType) {
        return switch (String.valueOf(classType).toLowerCase()) {
            case "economy" -> new EconomyRentalCost();
            case "business" -> new BusinessRentalCost();
            case "suv" -> new SuvRentalCost();
            default -> throw new IllegalArgumentException("Невідомий клас авто: " + classType);
        };
    }
}