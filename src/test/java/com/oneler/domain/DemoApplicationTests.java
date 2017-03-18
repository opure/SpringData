package com.oneler.domain;

import com.oneler.domain.enums.Gender;
import com.oneler.repository.CourseRepository;
import com.oneler.repository.StudentRepository;
import com.oneler.repository.TeacherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;
	@Test
	public void contextLoads() {
	}

	@Before
	public void init(){
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
	    for(int i =0; i<100;i++) {
	        Student student = new Student();
	        student.setAge(i >100?100:i);
	        student.setName("张三"+"_"+ String.format("%03d", i));
	        student.setGender(Gender.MALE);
	        students.add(student);

	        Teacher teacher = new Teacher();
	        teacher.setName("王老师"+"_"+String.format("%03d", i));
	        teachers.add(teacher);

	        Course course = new Course();
	        course.setCourseName("数学"+"_"+String.format("%03d", i));
	        courses.add(course);
        }
        studentRepository.save(students);
	    teacherRepository.save(teachers);
        courseRepository.save(courses);
        assertEquals(students.size(),studentRepository.count());
	}

	@Test
	public void  testSave() {
	    Student student = studentRepository.findOne(1L);
        Set<Teacher> teachers = new HashSet<>();
        teachers.add(teacherRepository.findOne(1L));
        teachers.add(teacherRepository.findOne(2L));
        student.setTeachers(teachers);
        studentRepository.save(student);
        System.out.println("");
    }

}
