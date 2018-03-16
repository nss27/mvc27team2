package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentAddr;
import model.StudentAddrDao;
import model.StudentDao;

@WebServlet("/addStudentAddrController.team2")
public class AddStudentAddrController extends HttpServlet {
	private Student student;
	private StudentAddr studentAddr;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		StudentDao studentDao = new StudentDao();
		this.student = studentDao.selectStudentOne(studentNo);
		request.setAttribute("studentNo", this.student.getStudentNo());
		request.setAttribute("studentId", this.student.getStudentId());
		request.getRequestDispatcher("/WEB-INF/views/student/addStudentAddr.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String address = request.getParameter("address");
		this.studentAddr = new StudentAddr();
		this.studentAddr.setStudentNo(studentNo);
		this.studentAddr.setAddress(address);
		StudentAddrDao studentAddrDao = new StudentAddrDao();
		studentAddrDao.insertStudentAddr(this.studentAddr);
		response.sendRedirect(request.getContextPath()+"/getStudentAddrListController.team2");
	}

}
