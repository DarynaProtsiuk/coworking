package task3;

public class Logger {
    private static int minutes = 9 * 60;

    public static void log(String source, String event) {
        int h = minutes / 60;
        int m = minutes % 60;
        System.out.printf("[%02d:%02d] [%s] %s%n", h, m, source, event);
        minutes++;
    }
}