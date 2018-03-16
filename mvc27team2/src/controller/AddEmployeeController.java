/*배건헤*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;

@WebServlet("/addEmployeeController.team2")
public class AddEmployeeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/employee/addEmployee.jsp").forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeePw(employeePw);
		
		EmployeeDao employeeDao = new EmployeeDao();
		int result = employeeDao.insertEmployee(employee);
		
		response.sendRedirect(request.getContextPath() +"/getEmployeeListController.team2");
		
	}
}
