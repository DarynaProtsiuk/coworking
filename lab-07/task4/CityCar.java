package task4;

public class CityCar implements EngineController, Acceleratable {

    @Override public void startEngine() { System.out.println("Car engine started."); }
    @Override public void stopEngine() { System.out.println("Car engine stopped."); }
    @Override public void accelerate(double speed) { System.out.println("Car accelerated to " + speed + " km/h."); }
}
