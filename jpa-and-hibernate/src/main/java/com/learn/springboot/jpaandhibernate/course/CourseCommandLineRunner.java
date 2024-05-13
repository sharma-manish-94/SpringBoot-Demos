package com.learn.springboot.jpaandhibernate.course;

import com.learn.springboot.jpaandhibernate.jpa.CourseJpaRepository;
import com.learn.springboot.jpaandhibernate.jpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJDBCRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "Learn SpringBoot", "Udemy"));
//        repository.insert(new Course(2, "Learn Hibernate", "Udemy"));
//        repository.insert(new Course(3, "Learn JPA", "Udemy"));
//        repository.insert(new Course(4, "Learn SpringCloud", "Udemy"));
//        repository.deleteById(2);
//        System.out.println(repository.findById(1));

        repository.save(new Course(1, "Learn SpringBoot", "Udemy"));
        repository.save(new Course(2, "Learn Hibernate", "Udemy"));
        repository.save(new Course(3, "Learn JPA", "Udemy"));
        repository.save(new Course(4, "Learn SpringData JPA", "Udemy"));

        repository.deleteById(2L);

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(4L));
        System.out.println(repository.findByAuthor("Udemy"));
        System.out.println(repository.findByName("Learn JPA"));
    }
}