package course;

import java.util.List;

public class SeniorParkingAgency extends ParkingAgency {

    public SeniorParkingAgency(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot maxParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.idleSpace() > maxParkingLot.idleSpace()) {
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot.park(car);
    }
}
