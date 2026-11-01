
import java.util.concurrent.atomic.AtomicInteger;

public class RentalAgreementFactory {
    private static final AtomicInteger CLIENT_ID =
            new AtomicInteger(15);

    private static final AtomicInteger VEHICLE_ID =
            new AtomicInteger(505);

    private static final AtomicInteger AGREEMENT_ID =
            new AtomicInteger(9012);

    public RentalAgreement create(RentalRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Запит на оренду не може бути порожнім");
        }

        Client client = Client.create(
                CLIENT_ID.incrementAndGet(),
                request.getName(),
                request.getDriverExperienceYears(),
                request.getPhone()
        );

        Vehicle vehicle = Vehicle.create(
                VEHICLE_ID.incrementAndGet(),
                request.getVehicleModel(),
                request.getCarClass(),
                request.getDailyRate()
        );

        return RentalAgreement.create(
                AGREEMENT_ID.incrementAndGet(),
                client,
                vehicle,
                request.getRentalDays(),
                request.getInsuranceType()
        );
    }
}

