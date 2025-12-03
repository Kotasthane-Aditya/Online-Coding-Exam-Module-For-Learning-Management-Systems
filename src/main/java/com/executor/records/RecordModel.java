package com.executor.records;

import jakarta.persistence.*;

@Entity
@Table(name = "show_save_code")
public class RecordModel {

    @Id
    @Column(name = "roll_no")
    private int rollNo;

    @Column(name = "java", columnDefinition = "TEXT")
    private String java;

    @Column(name = "c", columnDefinition = "TEXT")
    private String c;

    @Column(name = "python", columnDefinition = "TEXT")
    private String python;

    @Column(name = "java2", columnDefinition = "TEXT")
    private String java2;

    @Column(name = "c2", columnDefinition = "TEXT")
    private String c2;

    @Column(name = "python2", columnDefinition = "TEXT")
    private String python2;

    public RecordModel() {}

    public RecordModel(int rollNo, String java, String c, String python,String java2, String c2, String python2) {
        this.rollNo = rollNo;
        this.java = java;
        this.c = c;
        this.python = python;
        this.java2 = java2;
        this.c2 = c2;
        this.python2 = python2;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
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

    public String getJava2() {
        return java2;
    }

    public void setJava2(String java2) {
        this.java2 = java2;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getPython2() {
        return python2;
    }

    public void setPython2(String python2) {
        this.python2 = python2;
    }
}
