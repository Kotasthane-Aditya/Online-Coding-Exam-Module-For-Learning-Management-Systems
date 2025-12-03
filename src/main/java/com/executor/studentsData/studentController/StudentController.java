package com.executor.studentsData.studentController;

import com.executor.studentsData.studentModel.StudentModel;
import com.executor.studentsData.studentRepository.StudentRepo;
import com.executor.studentsData.studentService.StudentService;
import com.reference.Language;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepo studentRepo;

    // Add a single student
    @PostMapping
    public String add(@RequestBody StudentModel student) {
        int id = student.getRoll_no();
        if (!studentRepo.existsById(id)) {
            studentService.saveStudent(student);
            return "New Student Added";
        }else {
            return "student already exists.";
        }
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentModel student) {
        studentService.saveStudent(student);
        return "Student data saved successfully!";
    }

    // Get a single student by roll_no
    @GetMapping("/{id}")
    public StudentModel getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    // Get all students
    @GetMapping
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Save multiple student assignments
    @PostMapping("/assignments")
    public String saveAssignments(@RequestBody List<StudentModel> students) {
        studentService.saveAssignments(students);
        return "Assignments saved successfully!";
    }

    @PutMapping("/assignments")
    public String saveAssignments2(@RequestBody List<StudentModel> students) {
        studentService.saveAssignments(students);
        return "Assignments saved successfully!";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        System.out.println("delete :):):)");
        return studentService.deleteAllStudent();
    }
}
