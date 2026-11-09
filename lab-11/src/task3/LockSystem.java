package src.task3;

import java.time.LocalDateTime;

public interface LockSystem {
    public boolean programAccess(int roomNumber, LocalDateTime checkoutTime);
}
