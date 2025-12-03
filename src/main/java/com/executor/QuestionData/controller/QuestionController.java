package com.executor.QuestionData.controller;

import com.executor.QuestionData.model.QuestionModel;
import com.executor.QuestionData.repository.QuestionRepo;
import com.executor.QuestionData.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")

public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionRepo questionRepo;

    @PostMapping
    public String addQuestion(@RequestBody QuestionModel questionModel) {
        System.out.println("********* 007 ctrl ***********");
        int id = questionModel.getQId();
        if(!questionRepo.existsById(id)){
             questionService.addQuestion(questionModel);
             return "add question successfully";
        }{
            return "question already exists";
        }
    }

    @DeleteMapping("/{q_id}")
    public String deleteQuestion(@PathVariable Integer q_id) {
        System.out.println("********* 007 delete ***********");
        questionService.deleteQuestion(q_id);
        return "Question with ID " + q_id + " has been deleted.";
    }

    @GetMapping("/{q_id}")
    public QuestionModel getQuestion(@PathVariable Integer q_id) {
        return questionService.getQuestion(q_id);
    }

    @GetMapping
    public List<QuestionModel> getAllQuestions() {
        //     System.out.println("hello...");
        return questionService.getAllQuestions();
    }
}
