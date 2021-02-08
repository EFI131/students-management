package tutorial.springboot.students.management.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner ( StudentRepository repository ) {
        return args -> {
            Student anna = new Student("Anna",
                    "anna@asd.co.il",
                    LocalDate.of(2000, Month.APRIL, 20)
                    );

            Student alex = new Student("Alex",
                    "alex@asd.co.il",
                    LocalDate.of(2002, Month.APRIL, 20)
            );

            repository.saveAll(Arrays.asList(anna, alex));
        };
    }
}
