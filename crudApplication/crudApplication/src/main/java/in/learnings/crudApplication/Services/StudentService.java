package in.learnings.crudApplication.Services;

import in.learnings.crudApplication.Enitity.Student;
import in.learnings.crudApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentrepository;

    public StudentService(StudentRepository studentrepository){
        this.studentrepository =studentrepository;
    }

    public Student createStudent(Student studentReq){
        studentReq.setDeleted(false);
        Student studentReqp;
        studentReqp = studentrepository.save(studentReq);
        return studentReqp;
    }

    public Student getStudent(Long id) {
        Optional<Student> student = studentrepository.findByIdAndDeletedFalse(id);

        if(student.isPresent()){
            return student.get();
        }
        return null;

    }

    public List<Student> GetallStudent() {
        List<Student> studentList = studentrepository.findByDeletedFalse();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentrepository.findByIdAndDeletedFalse(id);

        if(existingStudent.isPresent()){
            Student saveToStudent = existingStudent.get();
            saveToStudent.setName(studentReq.getName());
            saveToStudent.setEmail(studentReq.getEmail());
            saveToStudent.setRoll(studentReq.getRoll());
            saveToStudent.setSubject(studentReq.getSubject());
            saveToStudent.setAge(studentReq.getAge());
            saveToStudent.setDeleted(false);

            return  studentrepository.save(saveToStudent);
        }
        return null;
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentrepository.existsById(id);

        if(!isStudent) return false;

        studentrepository.deleteById(id);

        return true;

    }

    public Boolean softDelete(Long id){
        Optional<Student> existingStudent = studentrepository.findByIdAndDeletedFalse(id);
        if(existingStudent.isEmpty()){
            return false;
        }
        Student saveToStudent = existingStudent.get();

        saveToStudent.setDeleted(true);
        studentrepository.save(saveToStudent);
        return true;





    }
}
