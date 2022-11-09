package com.gl.student.service;

import java.util.List;
import java.util.Optional;

import com.gl.student.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void saveStudent(Student theStudent);
	
	public void deleteById(int theId);

}
