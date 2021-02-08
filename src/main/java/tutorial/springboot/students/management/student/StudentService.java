package tutorial.springboot.students.management.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    /**
     * @function getStudents
     * @return a list of Student objects
     */
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail =  studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }
}
