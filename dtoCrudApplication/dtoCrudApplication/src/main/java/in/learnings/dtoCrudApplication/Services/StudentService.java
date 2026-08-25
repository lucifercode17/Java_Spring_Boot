package in.learnings.dtoCrudApplication.Services;

import in.learnings.dtoCrudApplication.Enitity.Student;
import in.learnings.dtoCrudApplication.Exception.DuplicateConflict;
import in.learnings.dtoCrudApplication.Exception.ResourceNotFound;
import in.learnings.dtoCrudApplication.dto.CreateStudentResponedto;
import in.learnings.dtoCrudApplication.dto.UpdateStudentReqDto;
import in.learnings.dtoCrudApplication.dto.UpdateStudentResDto;
import in.learnings.dtoCrudApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;
import in.learnings.dtoCrudApplication.dto.CreateStudentRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentrepository;

    public StudentService(StudentRepository studentrepository){
        this.studentrepository =studentrepository;
    }

    public CreateStudentResponedto createStudent(CreateStudentRequestDTO studentReqdto){

       Student student = mapToEntity(studentReqdto);
        System.out.println(emailExist(student));
        if(emailExist(student)){

            throw new DuplicateConflict("this email " +student.getEmail() +" exists");
        }
       Student studentResp = studentrepository.save(student);
       return mapToDto(studentResp);
    }

    public CreateStudentResponedto getStudent(Long id) throws DuplicateConflict {
        Student student = studentrepository
                .findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFound("no record found "));



        return mapToDto(student);
    }



    public List<CreateStudentResponedto> GetallStudent() {
        List<Student> studentList = studentrepository.findByDeletedFalse();
        return studentList.stream()
                .map(this::mapToDto)
                .toList();
    }



    public UpdateStudentResDto updateStudent(Long id, UpdateStudentReqDto updateStudentReqDto) {
        Student existingStudent = studentrepository
                .findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFound("no record found "));


        existingStudent.setName(updateStudentReqDto.getName());
        existingStudent.setRoll(updateStudentReqDto.getRoll());
        existingStudent.setSubject(updateStudentReqDto.getSubject());
        existingStudent.setAge(updateStudentReqDto.getAge());
        Student updatedStudent = studentrepository.save(existingStudent);
        return mapToUpdatedDto(updatedStudent);

    }



    public void deleteStudent(Long id) {
         studentrepository.findById(id).orElseThrow(() -> new ResourceNotFound("no record found to delete"));
         studentrepository.deleteById(id);

    }

    public void softDelete(Long id){
        Student existingStudent = studentrepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFound("no record found for soft delete "));
        existingStudent.setDeleted(true);
        studentrepository.save(existingStudent);

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
    private boolean emailExist(Student student) {
        return studentrepository.existsByEmail(student.getEmail());
    }




}
