package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepo;

	public StudentService(StudentRepository studentRepo) {
		this.studentRepo=studentRepo;
	}
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	public Optional<Student> getStudentById(Long id){
		return studentRepo.findById(id);
	}

	public Student createStudent(Student student) {
		return  studentRepo.save(student);
	}

	public Student updateStudent(Long id, Student student) {
	        student.setId(id);
	        return studentRepo.save(student);
	}
	 public void deleteStudent(Long id) {
	        studentRepo.deleteById(id);
	}
	
} 
