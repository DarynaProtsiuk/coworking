import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Reception {
    private final KeyCardPool pool;
    private final Map<String, KeyCard> cardsByRoom = new HashMap<>();

    public Reception(KeyCardPool pool) {
        this.pool = pool;
    }

    public Optional<KeyCard> checkIn(String guest, String room, String validUntil) {
        Optional<KeyCard> card = pool.acquire();
        if (card.isPresent()) {
            card.get().program(room, validUntil); // записує в карту доступ до номера
            cardsByRoom.put(room, card.get()); // в цьому номері лежить саме ця карта
            HotelLog.log("Рецепція", "Карта " + card.get().getId() + " → номер " + room + " (" + guest + ")");
        } else {
            HotelLog.log("Рецепція", "Вільних карт немає: гостю " + guest
                    + " видано тимчасовий механічний ключ від номера " + room);
        }
        return card;
    }

    public void checkOut(String room) {
        KeyCard card = cardsByRoom.remove(room);
        if (card == null) {
            HotelLog.log("Рецепція", "Виїзд з номера " + room + ": повернено механічний ключ");
            return;
        }
        pool.release(card);
    }

    public void tryOpenDoor(KeyCard card, String room) {
        boolean ok = card.opens(room);
        HotelLog.log("Замок " + room, "Карта " + card.getId() + (ok ? " → двері відчинено" : " → відмова"));
    }
}