package com.example.sms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.exception.NoStudentObjectFoundException;
import com.example.sms.exception.StudentNotFoundByIdException;
import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	// This method is used to register the student in database
	@Override
	public Student registerStudent(Student student) {
		return repository.save(student);
	}

	// This method is finding students by the id
	@Override
	public Student findStudentById(int id) {
		Optional<Student> optional = repository.findById(id);

		if (optional.isEmpty()) {
			throw new StudentNotFoundByIdException("Student object not found ");
		} else {
			return optional.get();
		}
	}

	// This Method is used to find all student present in database
	@Override
	public List<Student> findAllStudents() {
		List<Student> students = repository.findAll();

		if (students.isEmpty()) {
			throw new NoStudentObjectFoundException("Student objects not found");
		} else {
			return students;
		}
	}

	// This method is used to update the existing data in database

	@Override
	public Student updateStudentById(int id, Student student) {
		Optional<Student> optional = repository.findById(id);

		if (optional.isEmpty()) {
			throw new StudentNotFoundByIdException("Student object not found");
		} else {
			Student existingStudent = optional.get();
			student.setId(existingStudent.getId());
			return repository.save(student);
		}
	}

	// This method is used to delete the Student object in data base
	@Override
	public Student deleteStudentById(int id) {
		Optional<Student> optional = repository.findById(id);

		if (optional.isEmpty()) {
			throw new StudentNotFoundByIdException("Student object not found");
		} else {
			Student student = optional.get();
			repository.delete(student);
			return student;
		}
	}

}
