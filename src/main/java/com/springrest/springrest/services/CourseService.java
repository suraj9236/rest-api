package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entites.Course;

public interface CourseService {

	public List<Course> getCourses();
	
	public Course getCourse(int courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong);

}
