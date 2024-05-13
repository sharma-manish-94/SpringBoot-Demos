package com.learn.springboot.jpaandhibernate.jpa;

import com.learn.springboot.jpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long > {

    List<Course> findByAuthor(String author);
    Course findByName(String name);

}
