package task1;

public final class Log {
    private static int tick = 0;

    private Log() {}

    public static void write(String source, String message) {
        tick++;
        System.out.printf("[%02d] [%s] %s%n", tick, source, message);
    }
}