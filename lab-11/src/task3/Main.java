package src.task3;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        System.out.println(" ПЕРШИЙ ВИРОБНИК ЗАМКІВ ");

        ElectronicLock electronicLock = new ElectronicLock();

        LockSystem adapter = new LockAdapter(electronicLock);

        Reception reception = new Reception(adapter);

        LocalDateTime checkoutTime =
                LocalDateTime.of(2026, 11, 10, 12, 0);

        reception.programGuestAccess(305, checkoutTime);


        System.out.println("\nДРУГИЙ ВИРОБНИК ЗАМКІВ ");

        SecondVendorLock secondLock = new SecondVendorLock();

        LockSystem secondAdapter =
                new SecondLockAdapter(secondLock);

        Reception secondReception = new Reception(secondAdapter);

        secondReception.programGuestAccess(305, checkoutTime);
    }
}