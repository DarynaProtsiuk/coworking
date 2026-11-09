package src.task4;

import java.time.LocalTime;

public class AuditLog {

    public static void log(String employee, String operation,
                           String result) {
        System.out.println(
                "[" + LocalTime.now() + "] [AUDIT] Працівник: "
                        + employee + " | Операція: " + operation
                        + " | Результат: " + result
        );
    }
}
