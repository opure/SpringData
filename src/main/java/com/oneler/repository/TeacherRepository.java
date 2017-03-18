package com.oneler.repository;

import com.oneler.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by opure on 2017/3/18.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
