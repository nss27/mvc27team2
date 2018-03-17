package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddrDao;

@WebServlet("/deleteStudentAddrController.team2")
public class DeleteStudentAddrController extends HttpServlet {
	private StudentAddrDao studentAddrDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tableName = request.getParameter("tableName");
		if(tableName != null) {
			System.out.println(tableName);
			studentAddrDao = new StudentAddrDao();
			studentAddrDao.deleteStudentAddrAll(tableName);
		}else {
			int studentAddrNo = Integer.parseInt(request.getParameter("studentAddrNo"));
			studentAddrDao = new StudentAddrDao();
			studentAddrDao.deleteStudentAddrOne(studentAddrNo);
		}
		response.sendRedirect(request.getContextPath()+"/getStudentAddrListController.team2");
	}

}
