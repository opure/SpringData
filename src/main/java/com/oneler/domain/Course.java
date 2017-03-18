package com.oneler.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by opure on 2017/3/17.
 */
@Entity
public class Course extends AbstractPersistable<Long> {
    private String courseName;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Teacher> teachers = new HashSet<>();

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<Teacher> getTeachers() {

        return teachers;
    }
    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
