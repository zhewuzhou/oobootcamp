package course;

public class ParkingSpace {

    private Car car;
    private ParkingTicket parkingTicket;

    public ParkingSpace() {
    }

    public boolean isIdle() {
        return car == null;
    }

    public ParkingTicket park(Car car) {
        if (isIdle() == true) {
            this.car = car;
            this.parkingTicket = new ParkingTicket();
            return parkingTicket;
        }
        return null;
    }

    public Car unpark(ParkingTicket parkingTicket) {
        Car result = null;
        if (parkingTicket.equals(this.parkingTicket)) {
            this.parkingTicket = null;
            result = this.car;
            this.car = null;
        }
        return result;
    }
}
