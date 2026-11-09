package src.task3;

import java.time.LocalDateTime;

public class Reception {
    private LockSystem lockSystem;

    public Reception(LockSystem lockSystem) {
        this.lockSystem = lockSystem;
    }

    public void programGuestAccess(int roomNumber, LocalDateTime checkoutTime) {

        System.out.println("[10:00:00] [Reception] " + "Запит на програмування доступу до кімнати " + roomNumber);

        boolean result = lockSystem.programAccess(
                roomNumber, checkoutTime);

        if (result) {
            System.out.println("[10:00:00] [Reception] " + "Доступ успішно запрограмовано");
        } else {
            System.out.println("[10:00:00] [Reception] " + "Помилка програмування доступу");
        }
    }
}