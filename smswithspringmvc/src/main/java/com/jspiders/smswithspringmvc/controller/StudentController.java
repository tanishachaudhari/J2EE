package com.jspiders.smswithspringmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.smswithspringmvc.pojo.AdminPOJO;
import com.jspiders.smswithspringmvc.pojo.StudentPOJO;
import com.jspiders.smswithspringmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/add_student", method = RequestMethod.GET)
	public String getPageToAddStudent(HttpSession httpSession) {
		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			return "add_student";
		} else {
			return "log_in";
		}
	}

	@RequestMapping(path = "/add_student", method = RequestMethod.POST)
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long mobile,
			@RequestParam byte age, ModelMap modelMap) {
		studentService.addStudent(name, email, mobile, age);
		modelMap.addAttribute("message", "Student added");
		return "add_student";
	}

	@RequestMapping(path = "/get_students", method = RequestMethod.GET)
	public String getAllStudent(ModelMap modelMap, HttpSession httpSession) {
		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			List<StudentPOJO> students = studentService.getAllStudents();
			modelMap.addAttribute("students", students);
			return "get_students";
		} else {
			return "log_in";
		}
	}

	@RequestMapping(path = "/delete_student", method = RequestMethod.GET)
	public String getPageToDeleteStudent(ModelMap modelMap, HttpSession httpSession) {
		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			List<StudentPOJO> students = studentService.getAllStudents();
			modelMap.addAttribute("students", students);
			return "delete_student";
		} else {
			return "log_in";
		}
	}

	@RequestMapping(path = "/delete_student", method = RequestMethod.POST)
	public String deleteStudent(@RequestParam long id, ModelMap modelMap) {
		String message = studentService.deleteStudent(id);
		modelMap.addAttribute("message", message);
		List<StudentPOJO> students = studentService.getAllStudents();
		modelMap.addAttribute("students", students);
		return "delete_student";

	}

	@RequestMapping(path = "edit_student", method = RequestMethod.GET)
	public String getPageToEditStudent(ModelMap modelMap, HttpSession httpSession) {
		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			List<StudentPOJO> students = studentService.getAllStudents();
			modelMap.addAttribute("students", students);
			return "edit_student";
		} else {
			return "log_in";
		}
	}

	@RequestMapping(path = "edit_student", method = RequestMethod.POST)
	public String editStudent(@RequestParam long id, ModelMap modelMap) {
		StudentPOJO student = studentService.editStudent(id);
		modelMap.addAttribute("student", student);
		return "update_student";
	}

	@RequestMapping(path = "update_student", method = RequestMethod.POST)
	public String updateStudent(@RequestParam long id, @RequestParam String name, @RequestParam String email,
			@RequestParam long mobile, @RequestParam byte age, ModelMap modelMap) {
		studentService.updateStudent(id, name, email, mobile, age);
		List<StudentPOJO> students = studentService.getAllStudents();
		modelMap.addAttribute("students", students);
		modelMap.addAttribute("message", "Student updated");
		return "edit_student";
	}

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String getHomePage(HttpSession httpSession) {
		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			return "home";
		} else {
			return "log_in";
		}
	}

	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String getPageToSearchStudent(HttpSession httpSession) {
		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			return "search";
		} else {
			return "log_in";
		}
	}

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String searchStudentByPattern(@RequestParam String pattern, ModelMap modelMap) {
		List<StudentPOJO> students = studentService.searchStudentByPattern(pattern);
		modelMap.addAttribute("students", students);
		return "search";
	}
   @RequestMapping(path="/Search_id", method=RequestMethod.GET)
    public String getPageToSearchStudentById(HttpSession httpSession) {
	   AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			return "Search_id";
		} else {
			return "log_in";
		}
  }
   @RequestMapping(path = "/SearchId", method = RequestMethod.POST)
	public String searchStudentById(@RequestParam long id, ModelMap modelMap) {
		StudentPOJO students = studentService.searchStudentById(id);
		modelMap.addAttribute("students", students);
		return "Search_id";
}
   @RequestMapping(path = "/search_em", method = RequestMethod.GET)
	public String getPageToSearchStudentByEmail(HttpSession httpSession) {
		AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			return "search_em";
		} else {
			return "log_in";
		}
	}

	@RequestMapping(path = "/searchem", method = RequestMethod.POST)
	public String searchStudentByEmail(@RequestParam String email, ModelMap modelMap) {
		List<StudentPOJO> students = studentService.searchStudentByEmail(email);
		modelMap.addAttribute("students", students);
		return "search_em";
	}
	@RequestMapping(path="/search_age", method=RequestMethod.GET)
    public String getPageToSearchStudentByAge(HttpSession httpSession) {
	   AdminPOJO admin = (AdminPOJO) httpSession.getAttribute("admin");
		if (admin != null) {
			return "search_age";
		} else {
			return "log_in";
		}
  }
   @RequestMapping(path = "/searchage", method = RequestMethod.POST)
	public String searchStudentByAge(@RequestParam byte age, ModelMap modelMap) {
		List<StudentPOJO> students = studentService.searchStudentByAge(age);
		modelMap.addAttribute("students", students);
		return "search_age";
}
}