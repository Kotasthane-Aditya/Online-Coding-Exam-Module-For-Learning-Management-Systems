package com.executor.studentsData.studentRepository;

import com.executor.studentsData.studentModel.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Integer> {
}
