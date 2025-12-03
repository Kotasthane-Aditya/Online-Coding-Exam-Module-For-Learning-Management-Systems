package com.executor.studentsData.studentService;

import com.executor.studentsData.studentModel.StudentModel;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentModel student);
    StudentModel getStudent(int roll_no);
    List<StudentModel> getAllStudents();
    void saveAssignments(List<StudentModel> students);
    String deleteStudent(int id);
    String deleteAllStudent();
}
