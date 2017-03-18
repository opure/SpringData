package repository;

import com.oneler.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by opure on 2017/3/18.
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
}
