
package com.oneler.domain;

import com.oneler.repository.UserMapper;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private UserMapper userMapper;


    @Test
    public void contextLoads() {
    }

    @Test
    public void Test() {
        Person u = new Person();
        u.setAge(11);
        u.setName("11");
        userMapper.save(u);

    }


}

