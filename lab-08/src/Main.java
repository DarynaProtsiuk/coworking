public class Main {
    public static void main(String[] args) {

        RentalRegistrationService registrationService =
                new RentalRegistrationService(
                        new RentalAgreementFactory(),
                        new ConsoleRentalRepository()
                );

        RentalCompletionService completionService =
                new RentalCompletionService(
                        new SmsNotificationService()
                );

        RentalWorkflow workflow =
                new RentalWorkflow(
                        registrationService,
                        completionService
                );

        RentalUseCase controller = new RentalController(workflow);

        new RentalConsoleUI(controller).start();
    }
}