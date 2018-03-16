package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;

@WebServlet("/getEmplyeeAddrListController.team2")
public class GetEmplyeeAddrListController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		ArrayList<EmployeeAddr> list = employeeAddrDao.selectEmployeeList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeAddrList.jsp").forward(request,  response);
	}

}

