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
import model.PageMaker;
import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/getEmplyeeAddrListController.team2")
public class GetEmplyeeAddrListController extends HttpServlet {	
	private EmployeeAddrDao employeeAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String employeeSelect = request.getParameter("employeeSelect");
		String employeeSearch = request.getParameter("employeeSearch");
		if(employeeSelect == null && employeeSearch == null || employeeSelect != null && employeeSearch == "") {
			employeeAddrDao = new EmployeeAddrDao();
			
			int totalCurrentPage = 1;
			if(request.getParameter("currentPage") != null) {
				totalCurrentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			int totalCount  = employeeAddrDao.countEmployeeAddrListAll();
			int cutRow = 5;
			PageMaker pageMaker = new PageMaker(totalCount, cutRow, totalCurrentPage);
			
			ArrayList<Integer> pageNumber = new ArrayList<Integer>();
			for(int number = pageMaker.getStartPage(); number<=pageMaker.getEndPage(); number++) {
				pageNumber.add(number);
			}
			
			ArrayList<EmployeeAddr> list = employeeAddrDao.selectEmployeeAddrList(pageMaker.getStartRow(), pageMaker.getCutRow());
			
			request.setAttribute("list", list);
			request.setAttribute("pageMaker", pageMaker);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("employeeSelect", employeeSelect);
			request.setAttribute("employeeSearch", employeeSearch);
			request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeAddrList.jsp").forward(request, response);
		}else if(employeeSelect != null){
			employeeAddrDao = new EmployeeAddrDao();
			
			int totalCurrentPage = 1;
			if(request.getParameter("currentPage") != null) {
				totalCurrentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			int totalCount  = employeeAddrDao.countSearchEmployeeAddrList(employeeSelect, employeeSearch);
			int cutRow = 5;
			PageMaker pageMaker = new PageMaker(totalCount, cutRow, totalCurrentPage);
			
			ArrayList<Integer> pageNumber = new ArrayList<Integer>();
			for(int number = pageMaker.getStartPage(); number<=pageMaker.getEndPage(); number++) {
				pageNumber.add(number);
			}
			
			ArrayList<EmployeeAddr> list = employeeAddrDao.searchEmployeeAddrList(employeeSelect, employeeSearch, pageMaker.getStartRow(), pageMaker.getCutRow());
			
			request.setAttribute("list", list);
			request.setAttribute("pageMaker", pageMaker);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("employeeSelect", employeeSelect);
			request.setAttribute("employeeSearch", employeeSearch);
			request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeAddrList.jsp").forward(request, response);
		}
		
	}
}
		