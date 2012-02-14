package course;

public interface ParkingFacilitator {
    ParkingTicket park(Car car);

    Car unpark(ParkingTicket parkingTicket);

    int idleSpace();

    double volumPercentage();

    String report(String spaces);
}
