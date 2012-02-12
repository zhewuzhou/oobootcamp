package course;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TestParkingAgency {

    private ParkingAgency parkingAgency;

    @Before
    public void setUp() {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        for (int i = 0; i < 2; i++) {
            parkingLots.add(new ParkingLot(2));
        }
        parkingAgency = new ParkingAgency(parkingLots);
    }

    @Test
    public void test_should_park_car() {
        assertThat(parkingAgency.park(new Car()), notNullValue());
    }

    @Test
    public void test_should_not_park_car_given_no_parkingspace() {

    }
}
