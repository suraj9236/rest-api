package com.springrest.springrest.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entites.Course;
import com.springrest.springrest.services.CourseService;

@RestController 
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home () {
		
		return "Welcome to courses application";
	}
	
//	get the courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	
	{
		
		return this.courseService.getCourses();
		
	}
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Integer.parseInt(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourses(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse (@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deletCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}


