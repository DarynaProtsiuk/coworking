package task1;

public final class Logger {
    private static String currentTime = "12:00";

    private Logger() {}

    public static void setTime(String time) {
        currentTime = time;
    }

    public static void log(String source, String message) {
        System.out.println("[" + currentTime + "] [" + source + "] " + message);
    }
}
