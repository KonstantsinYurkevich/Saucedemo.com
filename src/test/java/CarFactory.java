import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

public class CarFactory {

    public static Car get() {
        Faker faker = new Faker();
        return Car.builder()
                .modal("Q7")
                .make(faker.animal().name())
                .maxSpeed(240)
                .build();
    }
}
