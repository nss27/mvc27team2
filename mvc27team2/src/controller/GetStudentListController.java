package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;


@WebServlet("/getStudentListController.team2")
public class GetStudentListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentDao = new StudentDao();
		ArrayList<Student> list = studentDao.selectStudent();
		
		request.getRequestDispatcher("/WEB-INF/views/getStudentList.jsp").forward(request, response);
	}

}
