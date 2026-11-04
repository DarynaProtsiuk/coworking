import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class KeyCardPool {
    private final int maxSize;
    private final Deque<KeyCard> free = new ArrayDeque<>();
    private final List<KeyCard> allCards = new ArrayList<>();

    public KeyCardPool(int maxSize) {
        this.maxSize = maxSize;
    }

    public Optional<KeyCard> acquire() {
        KeyCard card = free.pollFirst();
        if (card != null) {
            HotelLog.log("Пул", "Карту " + card.getId() + " видано повторно, без виготовлення");
            return Optional.of(card);
        }
        if (allCards.size() < maxSize) {
            card = new KeyCard("K-" + (allCards.size() + 1));
            allCards.add(card);
            return Optional.of(card);
        }
        return Optional.empty();
    }

    public void release(KeyCard card) {
        if (!allCards.contains(card) || free.contains(card)) {
            throw new IllegalStateException("Карта " + card.getId() + " не може бути повернута");
        }
        String oldRoom = card.getRoomNumber();
        card.reset();
        free.addLast(card);
        HotelLog.log("Пул", card.getId() + " повернено, доступ до " + oldRoom + " стерто");
    }

    public void printStatistics() {
        HotelLog.log("Пул", "Статистика видач:");
        for (KeyCard card : allCards) {
            System.out.println("    " + card.getId() + ": " + card.getIssueCount() + " видача/і");
        }
        HotelLog.log("Пул", "Загалом створено карт: " + allCards.size());
    }
}