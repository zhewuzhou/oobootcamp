package course;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TestParkingSpace {

    private Car car;
    private ParkingSpace parkingSpace;

    @Before
    public void setUp(){
        car = new Car();
        parkingSpace = new ParkingSpace();
    }

    @Test
    public void test_should_tell_busy_given_car_in() {
        parkingSpace.park(car);
        assertThat(parkingSpace.isIdle(), is(false));
    }

    @Test
    public void test_should_get_ticket_when_has_idle_parkinglot() {
        ParkingTicket parkingTicket = parkingSpace.park(car);
        assertThat(parkingTicket, is(not(nullValue())));
    }

    @Test
    public void test_should_not_get_ticket_when_parkinglot_busy() {
        Car first = new Car();
        Car second = new Car();
        parkingSpace.park(first);
        ParkingTicket parkingTicket = parkingSpace.park(second);
        assertThat(parkingTicket, nullValue());
    }

    @Test
    public void test_should_provide_the_right_ticket_when_uppark() {
        ParkingTicket parkingTicket = parkingSpace.park(car);
        Car parkedCar = parkingSpace.unpark(parkingTicket);
        assertThat(parkedCar, sameInstance(car));
    }

    @Test
    public void test_should_not_unpark_given_invalid_ticket() {
        parkingSpace.park(car);
        Car parkedCar = parkingSpace.unpark(new ParkingTicket());
        assertThat(parkedCar, nullValue());
    }
}
