package course;

import java.util.List;

public class ParkingChooser implements Chooser{

    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        ParkingLot parkingLot1 = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.idleSpace() > 0) {
                parkingLot1 = parkingLot;
                break;
            }
        }
        return parkingLot1;
    }
}
