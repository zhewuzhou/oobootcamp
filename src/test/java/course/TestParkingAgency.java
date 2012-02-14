package course;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TestParkingAgency {

    private ParkingAgency parkingAgency;

    @Before
    public void setUp() {
        List<ParkingFacilitator> parkingFacilitators = new ArrayList<ParkingFacilitator>();
        for (int i = 0; i < 2; i++) {
            parkingFacilitators.add(new ParkingLot(2));
        }
        parkingAgency = new ParkingAgency(parkingFacilitators, new ParkingChooser());
    }

    @Test
    public void test_should_park_car() {
        assertThat(parkingAgency.park(new Car()), notNullValue());
    }

    @Test
    public void test_should_not_park_car_given_no_parkingspace() {

    }

    @Test
    public void test_should_report() throws Exception {
        parkingAgency.park(new Car());
        assertThat(parkingAgency.report(""), is("parkingAgency\n  parkingLot\n    1/2\n  parkingLot\n    2/2"));
        assertThat(parkingAgency.report("  "), is("parkingAgency\n    parkingLot\n      1/2\n    parkingLot\n      2/2"));
    }
}
