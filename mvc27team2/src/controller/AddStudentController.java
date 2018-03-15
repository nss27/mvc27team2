/*나성수*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/addStudentController.team2")
public class AddStudentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/student/addStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		
		StudentDao studentDao = new StudentDao();
		int result = studentDao.insertStudent(student);
		
		response.sendRedirect(request.getContextPath()+"/getStudentListController.team2");
	}

}
