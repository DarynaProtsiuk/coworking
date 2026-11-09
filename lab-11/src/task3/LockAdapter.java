package src.task3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

public class LockAdapter implements LockSystem{
    private ElectronicLock lock;

    public LockAdapter(ElectronicLock lock) {
        this.lock = lock;
    }

    @Override
    public boolean programAccess(int roomNumber, LocalDateTime checkoutTime) {
        String roomCode = String.format("%04d", roomNumber);
        LocalDateTime baseDate = LocalDateTime.of(2000, 1, 1, 0, 0);

        long expirationSeconds = Duration
                .between(baseDate, checkoutTime)
                .getSeconds();

        System.out.println("LockAdapter: перетворення параметрів завершено");

        return lock.programLock(roomCode, expirationSeconds);
    }
}
