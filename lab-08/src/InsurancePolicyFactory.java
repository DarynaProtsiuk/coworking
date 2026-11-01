public class InsurancePolicyFactory {
    public static InsuranceTotalPolicy forType(String insuranceType) {
        return switch (String.valueOf(insuranceType).toLowerCase()) {
            case "basic" -> new BasicInsuranceTotal();
            case "full" -> new FullInsuranceTotal();
            default -> throw new IllegalArgumentException("Невідомий тип страховки: " + insuranceType);
        };
    }
}