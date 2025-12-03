package com.executor.studentsData.studentService;

import com.executor.studentsData.studentModel.StudentModel;
import com.executor.studentsData.studentRepository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {
    /**
     * add student (single)
     * delete student (single)
     */
    @Autowired
    private StudentRepo studentRepo;

    // Save multiple student assignments
    @Override
    public void saveAssignments(List<StudentModel> students) {
        studentRepo.saveAll(students);
    }

    @Override
    public String deleteStudent(int id) {
        System.out.println("delete *****");
        studentRepo.deleteById(id);
        return "delete success";
    }

    @Override
    public String deleteAllStudent() {
        studentRepo.deleteAll();
        return "delete all records";
    }


    @Override
    public void saveStudent(StudentModel student) {
        studentRepo.save(student);  // Save the single student in the database
    }

    @Override
    public StudentModel getStudent(int roll_no) {
        return studentRepo.findById(roll_no).orElse(null);  // Fetch student by roll number
    }

    @Override
    public List<StudentModel> getAllStudents() {
        return studentRepo.findAll();  // Get all students
    }

}
