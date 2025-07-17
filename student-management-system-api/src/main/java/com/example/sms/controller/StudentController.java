package com.example.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.model.Student;
import com.example.sms.service.StudentService;
import com.example.sms.util.ResponseStructure;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService service;

	
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> registerStudent(@RequestBody Student student) {
		Student student2 = service.registerStudent(student);

		ResponseStructure<Student> rs = new ResponseStructure<Student>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Student object created successfully");
		rs.setData(student2);

		return new ResponseEntity<ResponseStructure<Student>>(rs, HttpStatus.CREATED);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> findStudentById(@PathVariable int id) {
		Student student2 = service.findStudentById(id);

		ResponseStructure<Student> rs = new ResponseStructure<Student>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Student object found successfully");
		rs.setData(student2);

		return new ResponseEntity<ResponseStructure<Student>>(rs, HttpStatus.FOUND);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudents() {
		List<Student> students = service.findAllStudents();

		ResponseStructure<List<Student>> rs = new ResponseStructure<List<Student>>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Student objects found successfully");
		rs.setData(students);

		return new ResponseEntity<ResponseStructure<List<Student>>>(rs, HttpStatus.FOUND);
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateStudentById(@PathVariable int id,
			@RequestBody Student student) {
		Student student2 = service.updateStudentById(id, student);

		ResponseStructure<Student> rs = new ResponseStructure<Student>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Student object updated successfully");
		rs.setData(student2);

		return new ResponseEntity<ResponseStructure<Student>>(rs, HttpStatus.OK);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Student>> addStudent(@PathVariable int id) {
		Student student2 = service.deleteStudentById(id);

		ResponseStructure<Student> rs = new ResponseStructure<Student>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Student object deleted successfully");
		rs.setData(student2);

		return new ResponseEntity<ResponseStructure<Student>>(rs, HttpStatus.OK);
	}

}
