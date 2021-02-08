package tutorial.springboot.students.management.student;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    /**
     * @function getStudents
     * @return a list of Student objects
     */
    public List<Student> getStudents() {
        return Arrays.asList(
                new Student("Elena",
                        "Moses@gmail.com",
                        LocalDate.of(2000,	Month.APRIL,23),
                        12));
    }
}
