package course;

import java.util.List;

public class SeniorChooser implements Chooser{
    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        ParkingLot maxParkingLot = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (maxParkingLot==null || parkingLot.idleSpace() > maxParkingLot.idleSpace()) {
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot;
    }
}
