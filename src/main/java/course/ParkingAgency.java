package course;

import java.util.List;

public class ParkingAgency {
    protected List<ParkingLot> parkingLots;

    public ParkingAgency(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            ParkingTicket park = parkingLot.park(car);
            if (null != park) {
                return park;
            }
        }
        return null;
    }
}
