package com.executor.QuestionData.service;

import com.executor.QuestionData.model.QuestionModel;
import com.executor.QuestionData.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceIMPL implements QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public List<QuestionModel> getAllQuestions() {
        return questionRepo.findAll();
    }

    @Override
    public QuestionModel getQuestion(Integer q_id) {
        return questionRepo.findById(q_id).orElseThrow(() -> new RuntimeException("Question not found: " + q_id));
    }

    @Override
    public void deleteQuestion(Integer Q_id) {
        if(!questionRepo.existsById(Q_id)) {
            throw new RuntimeException("Question not found: " + Q_id);
        }
        System.out.println("********* 007 delete impl ***********");

        questionRepo.deleteById(Q_id);
    }

    @Override
    public QuestionModel addQuestion(QuestionModel questionModel) {
        System.out.println("********* 007 service ***********");
        return questionRepo.save(questionModel);
    }

}
