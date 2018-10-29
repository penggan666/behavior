package com.example.behavior.Repository;

import com.example.behavior.javabean.UserTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface timeRepository extends JpaRepository<UserTime, String> {
    List<UserTime> findAllByStartDate(Date date);

}
