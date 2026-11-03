import java.util.ArrayList;
import java.util.List;

public class AccommodationPackage {
    private String nameOfPackage;
    private String meals;
    private String transfer;
    private List<String> spaProcedures;
    private SkiPass skiPass;
    private Discount discount;


    public AccommodationPackage(String nameOfPackage, String meals, String transfer,
                                List<String> spaProcedures, SkiPass skiPass, Discount discount) {
        Task3.log("Package", "Дороге налаштування пакета «" + nameOfPackage + "»...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.nameOfPackage = nameOfPackage;
        this.meals = meals;
        this.transfer = transfer;
        this.spaProcedures = new ArrayList<>(spaProcedures);
        this.skiPass = skiPass;
        this.discount = discount;
    }

    // 2) Приватний конструктор: тільки для копіювання, без затримки
    private AccommodationPackage(AccommodationPackage other) {
        this.nameOfPackage = other.nameOfPackage;
        this.meals = other.meals;
        this.transfer = other.transfer;
        this.spaProcedures = new ArrayList<>(other.spaProcedures); // копія списку
        this.skiPass = other.skiPass.copy();                       // копія SkiPass
        this.discount = other.discount.copy();                     // копія Discount
    }

    public AccommodationPackage copy() {
        Task3.log("Package", "Пакет скопійовано без повторного налаштування");
        return new AccommodationPackage(this);
    }

    public void addSpaProcedure(String procedure) {
        spaProcedures.add(procedure);
        Task3.log("Package", "До пакета додано SPA-процедуру: " + procedure);
    }

    public void setSkiPassDays(int days){
        skiPass.setDays(days);
        Task3.log("Package", "Змінено тривалість скіпасу на " + days + " днів");
    }


    public void setDiscountPercent(int percent){
        discount.setPercent(percent);
        Task3.log("Package", "Змінено знижку на " + percent + "%");
    }

    @Override
    public String toString() {
        return "Package: " + nameOfPackage +
                "\nMeals: " + meals +
                "\nTransfer: " + transfer +
                "\nSpa procedures: " +spaProcedures+
                "\nSki pass: " + skiPass +
                "\nDiscount: " + discount;
    }
}

