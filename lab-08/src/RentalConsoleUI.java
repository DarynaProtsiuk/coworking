
import java.util.Scanner;

public class RentalConsoleUI {
    private final RentalUseCase useCase;
    private final Scanner scanner;

    public RentalConsoleUI(RentalUseCase useCase) {
        this.useCase = useCase;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Оформлення оренди автомобіля ===");

        try {
            System.out.print("Ім'я клієнта: ");
            String name = scanner.nextLine();

            System.out.print("Стаж водіння (років): ");
            int experience = Integer.parseInt(scanner.nextLine());

            System.out.print("Номер телефону: ");
            String phone = scanner.nextLine();

            System.out.print("Модель автомобіля: ");
            String model = scanner.nextLine();

            System.out.print("Клас авто (Economy/Business/SUV): ");
            String carClass = scanner.nextLine();

            System.out.print("Добова вартість: ");
            double dailyRate = Double.parseDouble(scanner.nextLine());

            System.out.print("Кількість днів оренди: ");
            int days = Integer.parseInt(scanner.nextLine());

            System.out.print("Страхування (Basic/Full): ");
            String insurance = scanner.nextLine();

            RentalRequest request = new RentalRequest(
                    name, experience, phone, model,
                    carClass, dailyRate, days, insurance
            );

            RentalResponse result = useCase.createRental(request);

            printRentalResult(result);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private void printRentalResult(RentalResponse result) {
        System.out.println("\n=== Ваучер оренди ===");
        System.out.println("Номер договору: " + result.getId());
        System.out.println("Клієнт: " + result.getClientName());
        System.out.println("Автомобіль: " + result.getVehicleModel());
        System.out.println("Оренда: " + result.getRentalTotal() + " грн");
        System.out.println("Страхування: " + result.getInsuranceTotal() + " грн");
        System.out.println("Застава: " + result.getDeposit() + " грн");
        System.out.println("Загальна вартість: " + result.getFinalPrice() + " грн");
    }
}
