public class Main {
    public static void main(String[] args) {
        runTask1KeyCards();
        runTask2Billing();
    }

    private static void runTask1KeyCards() {
        System.out.println("Завдання 1: ключ-карти");
        KeyCardPool pool = new KeyCardPool(5);
        Reception reception = new Reception(pool);

        String[] rooms  = {"301", "305", "308", "310", "315", "320", "325"};
        String[] guests = {"Шевчук", "Мельник", "Бондар", "Коваль", "Ткач", "Лисенко", "Мороз"};

        KeyCard cardOf305 = null;
        for (int i = 0; i < rooms.length; i++) {
            var card = reception.checkIn(guests[i], rooms[i], "10.11.2026");
            if (rooms[i].equals("305")) {
                cardOf305 = card.orElseThrow();
            }
        }

        reception.checkOut("305");
        reception.checkIn("Бойко", "412", "12.11.2026");
        reception.tryOpenDoor(cardOf305, "305");

        pool.printStatistics();
    }

    private static void runTask2Billing() {
        System.out.println("Завдання 2: служба розрахунків");
        Department reception  = new Department("Рецепція");
        Department restaurant = new Department("Ресторан");
        Department spa        = new Department("SPA");
        Department rental     = new Department("Прокат");

        String room = "305";
        reception.charge(room, "Проживання, 3 ночі", 4500);
        restaurant.charge(room, "Вечеря", 850);
        spa.charge(room, "Масаж", 1200);
        rental.charge(room, "Прокат лиж", 600);

        reception.issueFinalBill(room);
    }
}