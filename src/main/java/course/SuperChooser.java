package course;

import java.util.List;

public class SuperChooser implements Chooser{
    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        ParkingLot maxParkingLot = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (maxParkingLot==null || parkingLot.volumPercentage() > maxParkingLot.volumPercentage()) {
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot;
    }
}
