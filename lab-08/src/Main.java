public class Main {
    public static void main(String[] args) {
            LegacyRentalManager manager = new LegacyRentalManager(
                    new ConsoleRentalRepository(),
                    new SmsNotificationService()
            );
            manager.processRentalConsole();
    }
}