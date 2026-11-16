package task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static LocalTime time = LocalTime.of(10, 0, 0); // умовний час

    public static String now() {
        return time.format(FORMAT);
    }

    public static void log(String source, String event) {
        System.out.println("[" + now() + "] [" + source + "] " + event);
        time = time.plusMinutes(1); // після кожної події «минає» хвилина
    }
}
