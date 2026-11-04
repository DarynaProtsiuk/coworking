public final class HotelLog {
    private static int minutes = 8 * 60; // умовний час починається о 08:00

    private HotelLog() {}

    public static void log(String source, String message) {
        System.out.printf("[%02d:%02d] [%s] %s%n", minutes / 60, minutes % 60, source, message);
        minutes++;
    }

    public static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}