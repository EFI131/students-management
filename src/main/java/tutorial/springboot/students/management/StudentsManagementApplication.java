package tutorial.springboot.students.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.springboot.students.management.model.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class StudentsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsManagementApplication.class, args);
	}

	@GetMapping
	public List<Student> hello(){
		return Arrays.asList(
				new Student("Elena",
						"Moses@gmail.com",
						LocalDate.of(2000,	Month.APRIL,23),
						12));
	}
}
