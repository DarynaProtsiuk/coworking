package task1_lab12;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void log(String source, String event) {
        System.out.println("[" + LocalTime.now().format(FORMAT) + "] [" + source + "] " + event);
    }
}