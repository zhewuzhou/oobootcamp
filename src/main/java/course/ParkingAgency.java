package course;

import java.util.List;

public class ParkingAgency implements ParkingFacilitator {
    private List<ParkingFacilitator> parkingFacilitators;
    private Chooser parkingChooser;

    public ParkingAgency(List<ParkingFacilitator> parkingFacilitators, Chooser parkingChooser) {
        this.parkingFacilitators = parkingFacilitators;
        this.parkingChooser = parkingChooser;
    }

    public ParkingTicket park(Car car) {
        ParkingFacilitator parkingFacilitator = parkingChooser.getParkingLot(parkingFacilitators);
        if (parkingFacilitator != null) {
            return parkingFacilitator.park(car);
        }
        return null;
    }

    public Car unpark(ParkingTicket parkingTicket) {
        for (ParkingFacilitator parkingFacilitator : parkingFacilitators) {
            Car car = unpark(parkingTicket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public int idleSpace() {
        int spaces = 0;
        for (ParkingFacilitator parkingFacilitator : parkingFacilitators) {
            spaces += parkingFacilitator.idleSpace();
        }
        return spaces;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public double volumPercentage() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String report(String s) {
        String header = s + "parkingAgency\n";
        String report = header;
        for (ParkingFacilitator parkingFacilitator : parkingFacilitators) {
            report += parkingFacilitator.report(s + "  ");
            report += "\n";
        }
        report = report.trim();
        return report;
    }
}

