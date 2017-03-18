package com.oneler.repository;

import com.oneler.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by opure on 2017/3/18.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
