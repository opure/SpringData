package com.oneler.repository;

import com.oneler.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by opure on 2017/3/18.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
