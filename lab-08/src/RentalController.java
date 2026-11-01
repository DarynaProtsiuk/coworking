import java.util.Objects;

public class RentalController implements RentalUseCase {

    private final RentalWorkflow workflow;

    public RentalController(RentalWorkflow workflow) {
        this.workflow = Objects.requireNonNull(
                workflow, "Робочий процес оренди обов'язковий");
    }

    @Override
    public RentalResponse createRental(RentalRequest request) {
        return workflow.createRental(request);
    }
}
