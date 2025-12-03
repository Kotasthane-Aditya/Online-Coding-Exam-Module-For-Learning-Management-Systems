package com.executor.QuestionData.service;

import com.executor.QuestionData.model.QuestionModel;

import java.util.List;

public interface QuestionService {
    List<QuestionModel> getAllQuestions();

    QuestionModel getQuestion(Integer q_id);

    public void deleteQuestion(Integer q_id);
    QuestionModel addQuestion(QuestionModel questionModel);

}
