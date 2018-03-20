package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddrDao;

@WebServlet("/deleteEmployeeAddrController.team2")
public class DeleteEmployeeAddrController extends HttpServlet {
	private EmployeeAddrDao employeeAddrDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] checked = request.getParameterValues("employeeAddrNo");
		
		for(int i = 0; i<checked.length; i++) {
			int employeeAddrNo = Integer.parseInt(checked[i]);
			employeeAddrDao = new EmployeeAddrDao();
			employeeAddrDao.deleteEmployeeAddr(employeeAddrNo);		
		}
		response.sendRedirect(request.getContextPath()+"/getEmplyeeAddrListController.team2");
	}
}
