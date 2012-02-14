package course;

import java.util.List;

public class SuperChooser implements Chooser{
    public ParkingFacilitator getParkingLot(List<ParkingFacilitator> parkingFacilitatorList) {
        ParkingFacilitator maxParkingFacilitator = null;
        for (ParkingFacilitator parkingFacilitator : parkingFacilitatorList) {
            if (maxParkingFacilitator ==null || parkingFacilitator.volumPercentage() > maxParkingFacilitator.volumPercentage()) {
                maxParkingFacilitator = parkingFacilitator;
            }
        }
        return maxParkingFacilitator;
    }
}
