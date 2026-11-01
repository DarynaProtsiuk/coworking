public class ConsoleRentalRepository implements RentalRepository {
    @Override
    public void save(RentalAgreement agreement) {
        System.out.println("[База даних] Ваучер #" + agreement.getId() + " зафіксовано в системі.");
    }
}
