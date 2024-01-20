package com.jspiders.smswithspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.smswithspringmvc.pojo.StudentPOJO;
import com.jspiders.smswithspringmvc.repository.StudentRepository;

@Component
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public void addStudent(String name, String email, long mobile, byte age) {
		StudentPOJO studentPOJO = new StudentPOJO();
		studentPOJO.setName(name);
		studentPOJO.setEmail(email);
		studentPOJO.setMobile(mobile);
		studentPOJO.setAge(age);
		studentRepository.addStudent(studentPOJO);
	}

	public List<StudentPOJO> getAllStudents() {
		return studentRepository.getAllStudents();
	}

	public String deleteStudent(long id) {
		StudentPOJO studentToBeDeleted = null;
		List<StudentPOJO> students = studentRepository.getAllStudents();
		for (StudentPOJO student : students) {
			if (student.getId() == id) {
				studentToBeDeleted = student;
				break;
			}
		}
		if (studentToBeDeleted == null) {
			return "Student not found";
		} else {
			studentRepository.deleteStudent(studentToBeDeleted);
			return "Student deleted";
		}
	}

	public StudentPOJO editStudent(long id) {
		StudentPOJO studentToBeUpdated = null;
		List<StudentPOJO> students = studentRepository.getAllStudents();
		for (StudentPOJO student : students) {
			if (student.getId() == id) {
				studentToBeUpdated = student;
				break;
			}
		}
		return studentToBeUpdated;
	}

	public void updateStudent(long id, String name, String email, long mobile, byte age) {
		StudentPOJO studentPOJO = studentRepository.getStudentById(id);
		studentPOJO.setName(name);
		studentPOJO.setEmail(email);
		studentPOJO.setMobile(mobile);
		studentPOJO.setAge(age);
		studentRepository.addStudent(studentPOJO);

	}

	public List<StudentPOJO> searchStudentByPattern(String pattern) {
		return studentRepository.searchStudentByPattern(pattern);
	}

	public StudentPOJO searchStudentById(long id) {
		// TODO Auto-generated method stub
		StudentPOJO studentPOJO = studentRepository.getStudentById(id);
		return studentPOJO;
	}
	public List<StudentPOJO> searchStudentByEmail(String email) {
		return studentRepository.searchStudentByEmail(email);
	}
	public List<StudentPOJO> searchStudentByAge(byte age) {
		// TODO Auto-generated method stub
		return studentRepository.searchStudentByAge(age);
		
	}

}