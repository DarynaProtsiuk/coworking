package task4;

public class Task4 {
    public static void main(String[] args) {

            CityCar car = new CityCar();
            CargoDrone drone = new CargoDrone();

            VehicleMonitor monitor = new VehicleMonitor();
            FlightController flightController = new FlightController();

            monitor.startVehicle(car);
            car.accelerate(60);
            monitor.stopVehicle(car);

            System.out.println();

            monitor.startVehicle(drone);
            drone.accelerate(80);
            flightController.setAltitude(drone, 120);
            monitor.stopVehicle(drone);
    }
}