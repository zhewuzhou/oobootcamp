package course;

import java.util.List;

public class SuperChooser implements Chooser{
    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        ParkingLot maxParkingLot = parkingLotList.get(0);
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.volumPercentage() > maxParkingLot.volumPercentage()) {
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot;
    }
}
