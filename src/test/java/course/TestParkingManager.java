package course;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TestParkingManager {
    @Test
    public void test_should_park_given_only_managing_parkinglot(){
        List<ParkingFacilitator> parkingFacilitators = createParkingLots();
        ParkingManager manager = new ParkingManager(parkingFacilitators);
        Car car = new Car();
        ParkingTicket ticket = manager.park(car);
        assertThat(ticket, notNullValue());
    }

    private List<ParkingFacilitator> createParkingLots() {
        ParkingFacilitator parkingFacilitator = new ParkingLot(1);
        List<ParkingFacilitator> parkingFacilitators = new ArrayList<ParkingFacilitator>();
        parkingFacilitators.add(parkingFacilitator);
        return parkingFacilitators;
    }

    @Test
    public void test_should_park_car_given_only_agency() throws Exception {
        ParkingAgency parkingAgency = new ParkingAgency(createParkingLots(), new ParkingChooser());
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.add(parkingAgency);

        assertThat(parkingManager.park(new Car()), notNullValue());
    }

    @Test
    public void test_should_park_car_given_more_than_one_agency() throws Exception {
        ParkingAgency parkingAgency = new ParkingAgency(createParkingLots(), new ParkingChooser());
        ParkingAgency parkingAgency2 = new ParkingAgency(createParkingLots(), new ParkingChooser());
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.add(parkingAgency);
        parkingManager.add(parkingAgency2);

        assertThat(parkingManager.park(new Car()), notNullValue());
    }

    @Test
    public void test_should_report() throws Exception {
        ParkingManager parkingManager = new ParkingManager(createParkingLots());
        parkingManager.add(new ParkingAgency(createParkingLots(), new ParkingChooser()));
        assertThat(parkingManager.report(""), is("parkingManager\n  parkingLot\n   0/1\n  parkingAgency\n    parkingLot\n      0/1"));
    }
}
