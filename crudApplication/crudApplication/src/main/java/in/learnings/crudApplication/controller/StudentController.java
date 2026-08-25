package in.learnings.crudApplication.controller;

import in.learnings.crudApplication.Enitity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.learnings.crudApplication.Services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(201).body(createdStudent);

    }

    @GetMapping("get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.GetallStudent();

        if(studentList.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(studentList);
    }
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id, @RequestBody Student studentReq ){
        Student studentResp = studentService.updateStudent(id,studentReq);
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
