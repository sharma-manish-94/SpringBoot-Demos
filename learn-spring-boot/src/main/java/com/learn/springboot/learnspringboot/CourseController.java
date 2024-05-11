package com.learn.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	public static final String UDEMY_COURSE = "Udemy Course";

	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
				new Course(1, "Learn AWS", UDEMY_COURSE),
				new Course(2, "Learn Spring", UDEMY_COURSE),
				new Course(3, "Learn Docker", UDEMY_COURSE)
		);
	}
}
