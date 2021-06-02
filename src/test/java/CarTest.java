
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CarTest {

    @Test
    public void carTest() {
        Car car1 = CarFactory.get();
        Car car2 = CarFactory.get();
        log.fatal("Fatal");
        log.error("ERROR");
        log.warn("WARNING");
        log.info("INFO");
        log.debug("DEBUG");
        log.trace("TRACE");

        assertEquals(car1,car2);

    }
}
