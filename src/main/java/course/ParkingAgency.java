package course;

import java.util.List;

public class ParkingAgency {
    private List<ParkingLot> parkingLots;
    private Chooser parkingChooser;

    public ParkingAgency(List<ParkingLot> parkingLots, Chooser parkingChooser) {
        this.parkingLots = parkingLots;
        this.parkingChooser = parkingChooser;
    }

    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingChooser.getParkingLot(parkingLots);
        if (parkingLot != null) {
            return parkingLot.park(car);
        }
        return null;
    }

}

