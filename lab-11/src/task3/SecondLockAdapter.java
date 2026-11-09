package src.task3;
import java.time.LocalDateTime;
import java.time.Duration;

public class SecondLockAdapter implements LockSystem {

    private SecondVendorLock lock;

    public SecondLockAdapter(SecondVendorLock lock) {
        this.lock = lock;
    }

    @Override
    public boolean programAccess(int roomNumber, LocalDateTime checkoutTime) {

        int floor = roomNumber / 100;
        int wing = 1;
        int room = roomNumber % 100;

        LocalDateTime baseDate =
                LocalDateTime.of(2000, 1, 1, 0, 0);

        long validUntil = Duration.between(baseDate, checkoutTime)
                .getSeconds();

        System.out.println("[10:01:00] [SecondLockAdapter] "
                + "Перетворення параметрів");

        return lock.setRoomPermission(floor, wing, room, validUntil);
    }
}
