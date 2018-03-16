/*배건혜*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeAddr;
import model.EmployeeAddrDao;
import model.EmployeeDao;


@WebServlet("/addEmployeeAddrController.team2")
public class AddEmployeeAddrController extends HttpServlet {	
	private EmployeeDao employeeDao = null;
	private EmployeeAddrDao employeeAddrDao = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.selectEmployeeOne(employeeNo);
		request.setAttribute("employeeNo",employee.getEmployeeNo());
		request.setAttribute("employeeId",employee.getEmployeeId());
		request.getRequestDispatcher("/WEB-INF/views/employee/addEmployeeAddr.jsp").forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		String address = request.getParameter("address");		
		EmployeeAddr employeeAddr = new EmployeeAddr();
		employeeAddr.setEmployeeNo(employeeNo);
		employeeAddr.setAddress(address);
		EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.insertEmployeeAddr(employeeAddr);		
		response.sendRedirect(request.getContextPath()+"/getEmplyeeAddrListController.team2");
	}

}
