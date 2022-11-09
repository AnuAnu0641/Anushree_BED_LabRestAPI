package com.gl.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.student.entity.Student;
import com.gl.student.repository.StudentRepository;

@Repository
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
		
		//List<Student> students = studentRepository.findAll();
		//return students;
	}

	@Override
	public Student findById(int theId) {
		return studentRepository.findById(theId).get();
		
		//Student student = new Student();
		//student = studentRepository.findById(id).get();
		//return student;
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}

}
