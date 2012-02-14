package course;

import java.util.List;

public class SeniorChooser implements Chooser{
    public ParkingFacilitator getParkingLot(List<ParkingFacilitator> parkingFacilitatorList) {
        ParkingFacilitator maxParkingFacilitator = null;
        for (ParkingFacilitator parkingFacilitator : parkingFacilitatorList) {
            if (maxParkingFacilitator ==null || parkingFacilitator.idleSpace() > maxParkingFacilitator.idleSpace()) {
                maxParkingFacilitator = parkingFacilitator;
            }
        }
        return maxParkingFacilitator;
    }
}
