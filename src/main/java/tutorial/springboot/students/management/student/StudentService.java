package tutorial.springboot.students.management.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long studentId){
        if(!studentExists(studentId))
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        studentRepository.deleteById(studentId);
    }

    private boolean studentExists(Long studentId){
        return studentRepository.existsById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + "does not exist"
                ));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
            student.setName(name);

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent())
                throw new IllegalStateException("email taken");

            student.setEmail(email);
        }
    }
}
