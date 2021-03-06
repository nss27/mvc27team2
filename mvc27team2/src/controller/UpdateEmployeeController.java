/*배건혜*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;

@WebServlet("/updateEmployeeController.team2")
public class UpdateEmployeeController extends HttpServlet {
	private EmployeeDao employeeDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeNo = Integer.parseInt( request.getParameter("employeeNo"));
		employeeDao = new EmployeeDao();
		Employee employee = employeeDao.selectEmployeeOne(employeeNo);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/WEB-INF/views/employee/updateEmployee.jsp").forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
		String employeePw = request.getParameter("employeePw");
		Employee employee = new Employee();
		employee.setEmployeeNo(employeeNo);
		employee.setEmployeePw(employeePw);
		employeeDao = new EmployeeDao();
		employeeDao.updateEmployee(employee);
		response.sendRedirect(request.getContextPath() + "/getEmployeeListController.team2");	
	}
}
