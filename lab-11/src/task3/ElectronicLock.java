package src.task3;

public class ElectronicLock {
    public boolean programLock(String roomCode, long expirationSeconds){
        System.out.println( "ElectronicLock: отримано команду програмування");
        System.out.println("ElectronicLock: код кімнати = "+ roomCode);
        System.out.println("ElectronicLock: термін доступу = " +expirationSeconds + " секунд");
        return true;
    }
}
