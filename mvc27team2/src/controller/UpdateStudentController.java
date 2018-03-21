package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/updateStudentController.team2")
public class UpdateStudentController extends HttpServlet {
	private StudentDao studentDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		studentDao = new StudentDao();
		Student student = studentDao.selectStudentOne(studentNo);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/views/student/updateStudent.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentPw = request.getParameter("studentPw");
		Student student = new Student();
		student.setStudentNo(studentNo);
		student.setStudentPw(studentPw);
		studentDao = new StudentDao();
		studentDao.updateStudent(student);
		response.sendRedirect(request.getContextPath()+"/getStudentListController.team2");
	}

}
