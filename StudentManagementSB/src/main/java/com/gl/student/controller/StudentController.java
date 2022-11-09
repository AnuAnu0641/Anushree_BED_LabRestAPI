package com.gl.student.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.student.entity.Student;
import com.gl.student.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model theModel) {                                                                          // get list of students from database  // add list of students extracted from db to spring model(Map:Key-Value pair; key in frontend and value in backend) //Model is a class given by spring to interact between database and frontend. the data extracted from database(ie list of students will be stored in frontend in Model class) //Model accessible both in frontend and backend ; acts as a connection between frontend and backend
		List<Student> studentList = studentService.findAll();
		theModel.addAttribute("ListOfStudents", studentList);                                                             //here Students name will be used in list-students.jsp as ${ListOfStudents}
		return "list-students";
	}
	
	@RequestMapping("/display")
	public String displayListOfstudents(Model theModel) {
		List<Student> studentList = studentService.findAll();
		theModel.addAttribute("StudentsList", studentList);                                                                //here Students name will be used in display-list.jsp as ${StudentsList}
		return "display-list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("Student", theStudent);                                                                       //this "Student" should be same as that in student-form.jsp
		return "student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {                                   //this studentId should be same as that in list-students.jsp or else value will not come from frontend
		Student theStudent = studentService.findById(theId);                                                        //model is for mapping frontend and backend
		theModel.addAttribute("Student", theStudent);
		return "student-form";
	}
	
	@RequestMapping("/save")
	public String saveStudent(@RequestParam("id") int id, 
							  @RequestParam("firstName") String firstName, 
							  @RequestParam("lastName") String lastName, 
							  @RequestParam("course") String course,
							  @RequestParam("country") String country) {
		Student theStudent;
		if(id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		}
		else {
			theStudent=new Student(firstName, lastName, course, country);
		}
		studentService.saveStudent(theStudent);
		return "redirect:/student/list";                                                                   // use a redirect to prevent duplicate submissions
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {
		studentService.deleteById(id);
		return "redirect:/student/list";
	}
	
	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView modelAndView = new ModelAndView();
		if(user!=null) {
			modelAndView.addObject("msg", "Hi "+user.getName()+", you don't have permission to update and delete !");
		}
		else {
			modelAndView.addObject("msg", "You do not have permission to access this page!");
		}
		modelAndView.setViewName("403");
		return modelAndView;
	}
	
}
