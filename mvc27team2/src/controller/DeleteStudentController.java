/*나성수*/
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDao;

@WebServlet("/deleteStudentController.team2")
public class DeleteStudentController extends HttpServlet {
	private StudentDao studentDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		studentDao = new StudentDao();
		studentDao.deleteStudent(studentNo);
		response.sendRedirect(request.getContextPath()+"/getStudentListController.team2");
	}

}
