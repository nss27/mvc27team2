package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/updateStudentAddrController.team2")
public class UpdateStudentAddrController extends HttpServlet {
	private StudentAddrDao studentAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentAddrNo = Integer.parseInt(request.getParameter("studentAddrNo"));
		studentAddrDao = new StudentAddrDao();
		StudentAddr studentAddr = studentAddrDao.selectStudentAddrOne(studentAddrNo);
		request.setAttribute("studentAddr", studentAddr);
		request.getRequestDispatcher("/WEB-INF/views/student/updateStudentAddr.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		int studentAddrNo = Integer.parseInt(request.getParameter("studentAddrNo"));
		String address = request.getParameter("address");
		StudentAddr studentAddr = new StudentAddr();
		studentAddr.setStudentAddrNo(studentAddrNo);
		studentAddr.setAddress(address);
		studentAddrDao = new StudentAddrDao();
		studentAddrDao.updateStudentAddr(studentAddr);
		response.sendRedirect(request.getContextPath()+"/getStudentAddrListController.team2");
	}

}
