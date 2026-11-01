public class RentalCompletionService {

    private final NotificationService notificationService;

    public RentalCompletionService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public RentalResponse complete(RentalAgreement agreement) {
        notificationService.sendRentalConfirmation(
                agreement.getClientPhone());

        return RentalResponse.from(agreement);
    }
}