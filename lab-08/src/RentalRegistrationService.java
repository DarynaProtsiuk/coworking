public class RentalRegistrationService {

    private final RentalAgreementFactory factory;
    private final RentalRepository repository;

    public RentalRegistrationService(RentalAgreementFactory factory,
                                     RentalRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public RentalAgreement register(RentalRequest request) {
        RentalAgreement agreement = factory.create(request);

        agreement.approve();
        repository.save(agreement);

        return agreement;
    }
}
