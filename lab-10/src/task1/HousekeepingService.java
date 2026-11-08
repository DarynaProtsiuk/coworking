package task1;

public class HousekeepingService {
    public void prepareRoom(RoomFactory factory) {
        Cosmetic cosmetic = factory.createCosmetic();
        Minibar minibar = factory.createMinibar();
        Textile textile = factory.createTextile();

        System.out.println("Підготовка номера:");
        System.out.println(cosmetic.getInfo());
        System.out.println(minibar.getInfo());
        System.out.println(textile.getInfo());
        System.out.println("");
    }
}
