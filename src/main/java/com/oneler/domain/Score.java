package com.oneler.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by opure on 2017/3/17.
 */
@Entity
public class Score extends AbstractPersistable<Long> {
    @Column(length = 10)
    private double score;

    @OneToOne
    private Student student;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student getStudent() {

        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
