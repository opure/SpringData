package com.oneler.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DemoApplicationTests {

	private StudentRepository studentRepository;
	@Test
	public void contextLoads() {
	}

	@Before
	public void init(){

	}

}
