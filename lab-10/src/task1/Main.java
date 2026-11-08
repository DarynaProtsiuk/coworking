package task1;

public class Main {
    public static void main(String[] args) {
        HousekeepingService service = new HousekeepingService();

        service.prepareRoom(new StandardFactory());
        service.prepareRoom(new LuxuryFactory());
        service.prepareRoom(new FamilyFactory());

        service.prepareRoom(new NewCategoryFactory());
    }
}
