package course;

import java.util.List;

public class SuperParkingAgency extends ParkingAgency {

    public SuperParkingAgency(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot maxParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.volumPercentage() > maxParkingLot.volumPercentage()) {
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot.park(car);
    }
}
