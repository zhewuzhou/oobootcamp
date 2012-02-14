package course;

import java.util.List;

public class ParkingChooser implements Chooser{

    public ParkingFacilitator getParkingLot(List<ParkingFacilitator> parkingFacilitatorList) {
        ParkingFacilitator idleParkinglot = null;
        for (ParkingFacilitator parkingFacilitator : parkingFacilitatorList) {
            if (parkingFacilitator.idleSpace() > 0) {
                idleParkinglot = parkingFacilitator;
                break;
            }
        }
        return idleParkinglot;
    }
}
