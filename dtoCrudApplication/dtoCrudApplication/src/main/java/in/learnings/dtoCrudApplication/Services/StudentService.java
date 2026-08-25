package in.learnings.dtoCrudApplication.Services;

import in.learnings.dtoCrudApplication.Enitity.Student;
import in.learnings.dtoCrudApplication.dto.CreateStudentResponedto;
import in.learnings.dtoCrudApplication.dto.UpdateStudentReqDto;
import in.learnings.dtoCrudApplication.dto.UpdateStudentResDto;
import in.learnings.dtoCrudApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;
import in.learnings.dtoCrudApplication.dto.CreateStudentRequestDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class StudentService {
    private final StudentRepository studentrepository;

    public StudentService(StudentRepository studentrepository){
        this.studentrepository =studentrepository;
    }

    public CreateStudentResponedto createStudent(CreateStudentRequestDTO studentReqdto){
       Student student = mapToEntity(studentReqdto);
       Student studentResp = studentrepository.save(student);
       return mapToDto(studentResp);
    }

    public CreateStudentResponedto getStudent(Long id) {
        Optional<Student> student = studentrepository.findByIdAndDeletedFalse(id);



        if(student.isPresent()){
            return mapToDto(student.get());
        }
        return null;

    }

    public List<CreateStudentResponedto> GetallStudent() {
        List<Student> studentList = studentrepository.findByDeletedFalse();
        return studentList.stream()
                .map(this::mapToDto)
                .toList();
    }

    public UpdateStudentResDto updateStudent(Long id, UpdateStudentReqDto updateStudentReqDto) {
        Optional<Student> existingStudent = studentrepository.findByIdAndDeletedFalse(id);

        if(existingStudent.isPresent()){
            Student saveToStudent = existingStudent.get();
            saveToStudent.setName(updateStudentReqDto.getName());

            saveToStudent.setRoll(updateStudentReqDto.getRoll());
            saveToStudent.setSubject(updateStudentReqDto.getSubject());
            saveToStudent.setAge(updateStudentReqDto.getAge());
            Student updatedStudent = studentrepository.save(saveToStudent);

            return mapToUpdatedDto(updatedStudent);
        }
        return null;
    }



    public Boolean deleteStudent(Long id) {
        boolean isStudent = studentrepository.existsById(id);

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
    private Student mapToEntity(CreateStudentRequestDTO createStudentRequestDTO){
        Student student = new Student();
        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setEmail(createStudentRequestDTO.getEmail());
        student.setRoll(createStudentRequestDTO.getRoll());
        student.setSubject(createStudentRequestDTO.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());


        student.setDeleted(false);
        return student;
    }

    private CreateStudentResponedto mapToDto(Student Studentresp){
       CreateStudentResponedto responedto = new CreateStudentResponedto();
       responedto.setId(Studentresp.getId());
       responedto.setName(Studentresp.getName());
       responedto.setAge(Studentresp.getAge());
       responedto.setEmail(Studentresp.getEmail());
       responedto.setRoll(Studentresp.getRoll());
       responedto.setSubject(Studentresp.getSubject());
       responedto.setMessage("User created");
       responedto.setCreatedAt(LocalDateTime.now());
       responedto.setUpdatedAt(LocalDateTime.now());
       return responedto;


    }
    private UpdateStudentResDto mapToUpdatedDto(Student updatedStudent) {
        UpdateStudentResDto response = new UpdateStudentResDto();
        response.setAge(updatedStudent.getAge());
        response.setEmail(updatedStudent.getEmail());
        response.setId(updatedStudent.getId());
        response.setName(updatedStudent.getName());
        response.setRoll(updatedStudent.getRoll());
        response.setCreatedAt(updatedStudent.getCreatedAt());
        response.setSubject(updatedStudent.getSubject());
        response.setMessage("updated student");
        response.setUpdatedAt(LocalDateTime.now());

        return  response;

    }




}
