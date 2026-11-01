public class Client {
    private final int id;
    private final String name;
    private final int driverExperienceYears;
    private final String phone;

    private Client(int id, String name, int driverExperienceYears, String phone) {
        this.driverExperienceYears = driverExperienceYears;
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public static Client create (int id, String name, int driverExperienceYears, String phone) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ім'я клієнта не може бути порожнім");
        }
        if (driverExperienceYears < 0) {
            throw new IllegalArgumentException("Стаж водія не може бути від'ємним");
        }
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Телефон клієнта не може бути порожнім");
        }
        return new Client(id, name, driverExperienceYears, phone);

    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public double calculateDeposit() {
        double deposit = 5000.0;
        if (driverExperienceYears < 3) {
            deposit += 3000.0;
        }
        return deposit;
    }
}