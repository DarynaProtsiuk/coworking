package src.task3;

public class SecondVendorLock {
    public boolean setRoomPermission(int floor, int wing,
                                     int room, long validUntil) {

        System.out.println("[10:01:00] [SecondVendorLock] " + "Отримано команду встановлення доступу");

        System.out.println("[10:01:00] [SecondVendorLock] Поверх: " + floor);
        System.out.println("[10:01:00] [SecondVendorLock] Крило: " + wing);
        System.out.println("[10:01:00] [SecondVendorLock] Кімната: " + room);
        System.out.println("[10:01:00] [SecondVendorLock] Термін: " + validUntil);

        return true;
    }
}
