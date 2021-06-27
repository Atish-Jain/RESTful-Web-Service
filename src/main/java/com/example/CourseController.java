package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	CoursesRepository courseRepository;
	
	@Autowired
	UsersRepository usersRepository;

	
	@GetMapping(value = "/get")
	public List<Courses> getCourses() {
		return courseRepository.findAll();
	}

	@PostMapping(value = "/load")
	Courses createCourse(@RequestBody Courses courses)
	{
		return courseRepository.save(courses);
	}
	
	@PutMapping("/{courseId}/users/{userId}")
	Courses enrollUsersCourse(@PathVariable int courseId, @PathVariable int userId)
	{
		Courses course = courseRepository.findById(courseId).get();
		Users user = usersRepository.findById(userId).get();
		course.enrollUser(user);
		return courseRepository.save(course);
	}
	
}


