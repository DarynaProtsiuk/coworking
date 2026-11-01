import java.util.Scanner;

public class LegacyRentalManager {

    private final RentalRepository repository;
    private final NotificationService notificationService;

    public LegacyRentalManager(RentalRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void processRentalConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Оформлення оренди автомобіля ===");
        System.out.print("Введіть ім'я клієнта: ");
        String name = scanner.nextLine();
        System.out.print("Введіть клас авто (Economy/Business/SUV): ");
        String carClass = scanner.nextLine();

        Client client = Client.create(15, name, 4, "+380673332211");
        Vehicle vehicle = Vehicle.create(505, "Toyota RAV4", carClass, 1800.0);
        RentalAgreement agreement = RentalAgreement.create(9012, client, vehicle, 5, "Full");

        agreement.approve();

        String voucher = "Ваучер оренди #" + agreement.getId() +
                "\nКлієнт: " + agreement.getClientName()+
                "\nАвто: " + agreement.getVehicleModel()+
                "\nОренда: " + agreement.calculateRentalTotal() + " грн" +
                "\nСтраховка: " + agreement.calculateInsuranceTotal() + " грн" +
                "\nЗастава: " + agreement.calculateDepositAmount() + " грн" +
                "\nЗагалом: " + agreement.calculateFinalPrice() + " грн";
        System.out.println(voucher);

       repository.save(agreement);
       notificationService.sendRentalConfirmation(agreement.getClientPhone());
    }
}