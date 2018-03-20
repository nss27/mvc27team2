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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] checked = request.getParameterValues("studentAddrNo");
		
		for(int i = 0; i<checked.length; i++) {
			int studentAddrNo = Integer.parseInt(checked[i]);
			studentAddrDao = new StudentAddrDao();
			studentAddrDao.deleteStudentAddr(studentAddrNo);
		}
		
		response.sendRedirect(request.getContextPath()+"/getStudentAddrListController.team2");
	}

}
