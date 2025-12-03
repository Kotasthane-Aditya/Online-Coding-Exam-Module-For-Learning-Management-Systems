package com.executor.studentsData.studentModel;


import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentModel {
    @Id
    private int roll_no;
    private Integer question_assign;
    private String remark;
    private Integer question_assign2;

    public Integer getQuestion_assign2() {
        return question_assign2;
    }

    public void setQuestion_assign2(Integer question_assign2) {
        this.question_assign2 = question_assign2;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    private String remark2;

    public StudentModel() {}

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public Integer getQuestion_assign() {
        return question_assign;
    }

    public void setQuestion_assign(Integer question_assign) {
        this.question_assign = question_assign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
