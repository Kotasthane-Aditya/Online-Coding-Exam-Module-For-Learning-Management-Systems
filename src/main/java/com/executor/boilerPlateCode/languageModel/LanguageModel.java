package com.executor.boilerPlateCode.languageModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class LanguageModel {

    @Id
    @Column(name = "Q_id")
    @JsonProperty("qId")  // Maps JSON key "qId" to this field
    private Integer qid;

    @Column(name = "JAVA", columnDefinition = "TEXT")
    private String java;

    @Column(name = "C", columnDefinition = "TEXT")
    private String c;

    @Column(name = "PYTHON", columnDefinition = "TEXT")
    private String python;

    public LanguageModel() {}

    public LanguageModel(String java, String c, String python) {
        this.java = java;
        this.c = c;
        this.python = python;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getPython() {
        return python;
    }

    public void setPython(String python) {
        this.python = python;
    }

    @Override
    public String toString() {
        return "********LanguageModel{" +
                "qid=" + qid +
                ", java='" + java + '\'' +
                ", c='" + c + '\'' +
                ", python='" + python + '\'' +
                '}';
    }
}
