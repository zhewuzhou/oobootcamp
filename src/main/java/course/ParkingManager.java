package course;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingAgency {

    private List<ParkingAgency> parkingFacilitators = new ArrayList<ParkingAgency>();

    public ParkingManager(List<ParkingFacilitator> parkingFacilitators) {
        super(parkingFacilitators, new ParkingChooser());
    }


    public ParkingManager() {
        super(null, new ParkingChooser());
    }

    public void add(ParkingAgency parkingAgency) {
        this.parkingFacilitators.add(parkingAgency);
    }

    @Override
    public ParkingTicket park(Car car) {
        for (ParkingAgency agency : parkingFacilitators) {
            ParkingTicket ticket = agency.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return super.park(car);
    }

    @Override
    public String report(String s) {
        String header = s + "parkingManager\n";
        String report = header;
        report += super.report(s + "  ");
        for (ParkingFacilitator parkingFacilitator : parkingFacilitators) {
            report += s + "  ";
            report += parkingFacilitator.report(s + "  ");
            report += "\n";
        }
        report = report.trim();
        return report;
    }
}
