package course;

import java.util.List;

public class SeniorChooser implements Chooser{
    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        ParkingLot maxParkingLot = parkingLotList.get(0);
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.idleSpace() > maxParkingLot.idleSpace()) {
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot;
    }
}
