package course;

import java.util.List;

public class ParkingChooser implements Chooser{

    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        ParkingLot idleParkinglot = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.idleSpace() > 0) {
                idleParkinglot = parkingLot;
                break;
            }
        }
        return idleParkinglot;
    }
}
