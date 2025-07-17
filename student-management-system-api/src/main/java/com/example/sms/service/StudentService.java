package com.example.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sms.model.Student;

@Service
public interface StudentService {

	Student registerStudent(Student student);

	Student findStudentById(int id);

	List<Student> findAllStudents();

	Student updateStudentById(int id, Student student);

	Student deleteStudentById(int id);

}
