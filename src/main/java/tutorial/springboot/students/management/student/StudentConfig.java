package tutorial.springboot.students.management.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner ( StudentRepository repository ) {
        return args -> {
            Student anna = new Student("Anna",
                    "anna@asd.co.il",
                    LocalDate.of(2000, Month.APRIL, 20),
                    21
                    );

            Student alex = new Student("Alex",
                    "alex@asd.co.il",
                    LocalDate.of(2002, Month.APRIL, 20),
                    19
            );
        };
    }
}
