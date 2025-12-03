package com.executor.QuestionData.repository;

import com.executor.QuestionData.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionModel, Integer> {
}
