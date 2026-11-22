package task1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class Logger {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HH:mm");
    private static final LocalTime START_TIME = LocalTime.of(8, 0);
    private static final int STEP_MINUTES = 10;

    private static LocalTime currentTime = START_TIME;

    private Logger() {
    }

    public static void log(String source, String event) {
        System.out.println("[" + currentTime.format(FORMAT) + "] [" + source + "] " + event);
        currentTime = currentTime.plusMinutes(STEP_MINUTES);
    }

    public static void section(String title) {
        System.out.println();
        System.out.println(title);
    }

    public static void reset() {
        currentTime = START_TIME;
    }

    public static String money(double value) {
        return String.format(Locale.US, "%.2f грн", value);
    }
}