package in.learnings.dtoCrudApplication.controller;

import in.learnings.dtoCrudApplication.Enitity.Student;
import in.learnings.dtoCrudApplication.Services.StudentService;
import in.learnings.dtoCrudApplication.dto.CreateStudentRequestDTO;
import in.learnings.dtoCrudApplication.dto.CreateStudentResponedto;
import in.learnings.dtoCrudApplication.dto.UpdateStudentReqDto;
import in.learnings.dtoCrudApplication.dto.UpdateStudentResDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping()
    public ResponseEntity<CreateStudentResponedto> createStudent(@Valid @RequestBody CreateStudentRequestDTO createStudentRequestDTO){
        CreateStudentResponedto createdStudent = studentService.createStudent(createStudentRequestDTO);
        return ResponseEntity.status(201).body(createdStudent);

    }

    @GetMapping("get")
    public ResponseEntity<CreateStudentResponedto> getStudent(@RequestParam Long id){
        CreateStudentResponedto studentResp = studentService.getStudent(id);
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<CreateStudentResponedto>> getAllStudent(){
        List<CreateStudentResponedto> studentList = studentService.GetallStudent();

        if(studentList.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(studentList);
    }
    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResDto> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentReqDto updateStudentReqDto){
        UpdateStudentResDto studentResp = studentService.updateStudent(id,updateStudentReqDto);
        if(studentResp == null){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(studentResp);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("record deleted");
    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> softDelete(@RequestParam Long id){
        Boolean isDeleted = studentService.softDelete(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("record deleted");
    }





}
