public class FullInsuranceTotal implements InsuranceTotalPolicy{
    @Override
    public double calculateInsuranceTotal (int days) {
        return 500.0 * days;
    }
}
