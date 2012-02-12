package course;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestParkingLot {

    private ParkingLot parkingLot;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(2);
    }

    @Test
    public void test_parkinglot_should_konw_idle_when_no_car() {
        assertThat(parkingLot.getIdleParkingSpace(), notNullValue());
    }

    @Test
    public void test_parkinglot_should_know_busy_when_all_parkingspace_used() {
        for (int i = 0; i < 2; i++) {
            parkingLot.park(new Car());
        }
        assertThat(parkingLot.getIdleParkingSpace(), nullValue());
    }

    @Test
    public void test_parkinglot_should_park_cars_when_have_idle_parkingspace() {
        ParkingTicket parkingTicket = parkingLot.park(new Car());
        assertThat(parkingTicket, notNullValue());
    }

    @Test
    public void test_parkinglot_should_unpart_cars_when_given_valid_ticket() {
        Car myCar = new Car();
        ParkingTicket parkingTicket = parkingLot.park(myCar);
        assertThat(myCar, sameInstance(parkingLot.unpark(parkingTicket)));
    }

    @Test
    public void test_parkinglot_should_know_num_of_idle_parkingspace() {
        assertThat(parkingLot.idleSpace(), is(2));
    }

    @Test
    public void test_parkinglot_should_know_num_of_idle_parkingspace_given_park_one_car() {
        Car car = new Car();
        parkingLot.park(car);
        assertThat(parkingLot.idleSpace(), is(1));
    }

    @Test
    public void test_should_create_by_num_of_parkingspace() {
        ParkingLot myParkingLot = new ParkingLot(3);
        assertThat(myParkingLot.idleSpace(), is(3));
    }

    @Test
    public void test_should_know_volume_percentage_given_no_car() {
        assertEquals(1, parkingLot.volumPercentage(), 0.01);
    }

    @Test
    public void test_should_know_volume_percentage() {
        Car car = new Car();
        parkingLot.park(car);
        assertEquals(0.5, parkingLot.volumPercentage(), 0.01);
    }
}
