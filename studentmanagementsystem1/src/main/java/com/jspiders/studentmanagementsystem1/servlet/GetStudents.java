package com.jspiders.studentmanagementsystem1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.studentmanagementsystem1.jdbc.StudentJDBC;
import com.jspiders.studentmanagementsystem1.object.Student;

@WebServlet("/get_students")
public class GetStudents extends HttpServlet {

	private static final long serialVersionUID = 1L;

	StudentJDBC studentJDBC = new StudentJDBC();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> students = studentJDBC.getAllStudents();
		req.setAttribute("students", students);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("get_students.jsp");
		requestDispatcher.forward(req, resp);
	}

}

