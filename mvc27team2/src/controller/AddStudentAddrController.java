/*나성수*/
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
	private StudentDao studentDao = null;
	private StudentAddrDao studentAddrDao = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		studentDao = new StudentDao();
		studentAddrDao = new StudentAddrDao();
		Student student = studentDao.selectStudentOne(studentNo);
		request.setAttribute("studentNo", student.getStudentNo());
		request.setAttribute("studentId", student.getStudentId());
		int count = studentAddrDao.countStudentAddrList(studentNo);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/views/student/addStudentAddr.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String address = request.getParameter("address");
		StudentAddr studentAddr = new StudentAddr();
		studentAddr.setStudentNo(studentNo);
		studentAddr.setAddress(address);
		studentAddrDao = new StudentAddrDao();
		studentAddrDao.insertStudentAddr(studentAddr);
		response.sendRedirect(request.getContextPath()+"/getStudentAddrListController.team2");
	}
}
