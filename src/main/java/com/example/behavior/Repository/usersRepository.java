package com.example.behavior.Repository;

import com.example.behavior.javabean.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface usersRepository extends JpaRepository<users, String> {
    @Query(value = "select edu from users;", nativeQuery = true)
    List<String> getAlledu();

    @Query(value = "select gender from users;", nativeQuery = true)
    List<String> getAllegender();

    @Query(value = "select is_city from users;", nativeQuery = true)
    List<String> getAllisCity();

    @Query(value = "select province from users;", nativeQuery = true)
    List<String> getAllprovince();

    @Query(value = "select job from users;", nativeQuery = true)
    List<String> getAlljob();

}
