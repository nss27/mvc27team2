package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentAddrDao;
import model.StudentDao;


@WebServlet("/getStudentListController.team2")
public class GetStudentListController extends HttpServlet {
	private StudentDao studentDao = null;
	private StudentAddrDao studentAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentDao = new StudentDao();
		studentAddrDao = new StudentAddrDao();
		ArrayList<Student> list = studentDao.selectStudentList();
		int studentAddrCount = 0;
		for(Student student : list) {
			studentAddrCount = studentAddrDao.countStudentAddrList(student.getStudentNo());
			student.setStudentAddrCount(studentAddrCount);
		}
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentList.jsp").forward(request, response);
	}

}
