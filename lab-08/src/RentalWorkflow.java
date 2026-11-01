public class RentalWorkflow {

    private final RentalRegistrationService registrationService;
    private final RentalCompletionService completionService;

    public RentalWorkflow(RentalRegistrationService registrationService,
                          RentalCompletionService completionService) {
        this.registrationService = registrationService;
        this.completionService = completionService;
    }

    public RentalResponse createRental(RentalRequest request) {
        RentalAgreement agreement = registrationService.register(request);

        return completionService.complete(agreement);
    }
}