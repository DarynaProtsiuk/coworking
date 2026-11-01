public class SmsNotificationService implements NotificationService {
    @Override
    public void sendRentalConfirmation(String phone) {
        System.out.println("[SMS] Підтвердження оренди надіслано на номер " + phone);
    }
}
