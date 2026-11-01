public class BasicInsuranceTotal implements InsuranceTotalPolicy{
    @Override
    public double calculateInsuranceTotal (int days) {
        return 200.0 * days;
    }
}
