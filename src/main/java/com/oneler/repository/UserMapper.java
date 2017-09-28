package com.oneler.repository;

import com.oneler.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<Person, Integer> {
}
