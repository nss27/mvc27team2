package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;
import model.EmployeeDao;
import model.StudentAddr;
import model.StudentAddrDao;


@WebServlet("/updateEmployeeAddrController.team2")
public class UpdateEmployeeAddrController extends HttpServlet {
	private EmployeeAddrDao employeeAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeAddrNo = Integer.parseInt(request.getParameter("employeeAddrNo"));
		employeeAddrDao = new EmployeeAddrDao();
		EmployeeAddr employeeAddr = employeeAddrDao.selectEmployeeAddrOne(employeeAddrNo);
		request.setAttribute("employeeAddr", employeeAddr);
		request.getRequestDispatcher("WEB-INF/views/employee/updateEmployeeAddr.jsp").forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		int employeeAddrNo = Integer.parseInt(request.getParameter("employeeAddrNo"));
		String address = request.getParameter("address");
		EmployeeAddr employeeAddr = new EmployeeAddr();
		employeeAddr.setEmployeeAddrNo(employeeAddrNo);
		employeeAddr.setAddress(address);
		employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.updateEmployeeAddr(employeeAddr);
		response.sendRedirect(request.getContextPath()+"/getEmplyeeAddrListController.team2");
		
	}

}
