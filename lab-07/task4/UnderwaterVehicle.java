package task4;

public class UnderwaterVehicle implements EngineController, Acceleratable, Submersible {
    @Override public void startEngine() { System.out.println("Underwater vehicle started.");}
    @Override public void stopEngine() { System.out.println("Underwater vehicle stopped.");}
    @Override public void accelerate(double speed) {System.out.println("Underwater speed set to " + speed + " km/h.");}
    @Override public void submergeToDepth(double meters) { System.out.println("Submerged to " + meters + " meters.");}
}
