package course;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpace> parkingSpaces;

    public ParkingLot(int num) {
        List<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();
        for(int i=0; i<num; i++){
            parkingSpaces.add(new ParkingSpace());
        }
        this.parkingSpaces = parkingSpaces;
    }

    public ParkingSpace getIdleParkingSpace() {
        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (parkingSpace.isIdle()) {
                return parkingSpace;
            }
        }
        return null;
    }

    public ParkingTicket park(Car car) {
        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (parkingSpace.isIdle()) {
                return parkingSpace.park(car);
            }
        }
        return null;
    }

    public Car unpark(ParkingTicket parkingTicket) {
        for (ParkingSpace parkingSpace : parkingSpaces) {
            Car unpark = parkingSpace.unpark(parkingTicket);
            if (null != unpark) {
                return unpark;
            }
        }
        return null;
    }

    public int idleSpace() {
        int result = 0;
        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (parkingSpace.isIdle()) {
                result += 1;
            }
        }
        return result;
    }

    public double volumPercentage() {
        return (float)((1.0*idleSpace())/parkingSpaces.size());
    }
}
