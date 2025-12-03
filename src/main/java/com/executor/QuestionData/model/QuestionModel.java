package com.executor.QuestionData.model;


import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionModel {

    @Id
    @Column(name = "Q_id")
    private int qId;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private String level;

    @Column(name = "statement", columnDefinition = "TEXT")
    private String statement;

    @Column(name = "input", columnDefinition = "TEXT")
    private String input;

    @Column(name = "output", columnDefinition = "TEXT")
    private String output;

    // Getters & Setters
    public int getQId() {
        return qId;
    }

    public void setQId(int qId) {
        this.qId = qId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public QuestionModel() {
    }
}

