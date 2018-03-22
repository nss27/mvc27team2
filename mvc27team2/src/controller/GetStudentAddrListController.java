/*나성수*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/getStudentAddrListController.team2")
public class GetStudentAddrListController extends HttpServlet {
	private StudentAddrDao studentAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentAddrDao = new StudentAddrDao();
		ArrayList<StudentAddr> list = studentAddrDao.selectStudentAddrList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentAddrList.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentAddrDao = new StudentAddrDao();
		request.setCharacterEncoding("utf8");
		String studentSelect = request.getParameter("studentSelect");
		String studentSearch = request.getParameter("studentSearch");
		if(studentSearch != "") {
			ArrayList<StudentAddr> list = studentAddrDao.searchStudentAddrList(studentSelect, studentSearch);
			request.setAttribute("list", list);
		}else if(studentSearch == ""){
			ArrayList<StudentAddr> list = studentAddrDao.selectStudentAddrList();
			request.setAttribute("list", list);
		}
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentAddrList.jsp").forward(request, response);
	}

}
