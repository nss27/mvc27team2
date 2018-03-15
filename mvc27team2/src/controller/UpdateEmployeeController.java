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
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeNo = Integer.parseInt( request.getParameter("employeeNo"));
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.selectEmployeeOne(employeeNo);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("WEB-INF/views/updateEmployee.jsp").forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
