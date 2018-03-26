/*나성수*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageMaker;
import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/getStudentAddrListController.team2")
public class GetStudentAddrListController extends HttpServlet {
	private StudentAddrDao studentAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String studentSelect = request.getParameter("studentSelect");
		String studentSearch = request.getParameter("studentSearch");
		if(studentSelect == null && studentSearch == null || studentSelect != null && studentSearch == "") {
			studentAddrDao = new StudentAddrDao();
			
			int totalCurrentPage = 1;
			if(request.getParameter("currentPage") != null) {
				totalCurrentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			int totalCount  = studentAddrDao.countStudentAddrListAll();
			int cutRow = 5;
			PageMaker pageMaker = new PageMaker(totalCount, cutRow, totalCurrentPage);
			
			ArrayList<Integer> pageNumber = new ArrayList<Integer>();
			for(int number = pageMaker.getStartPage(); number<=pageMaker.getEndPage(); number++) {
				pageNumber.add(number);
			}
			
			ArrayList<StudentAddr> list = studentAddrDao.selectStudentAddrList(pageMaker.getStartRow(), pageMaker.getCutRow());
			
			request.setAttribute("list", list);
			request.setAttribute("pageMaker", pageMaker);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("studentSelect", studentSelect);
			request.setAttribute("studentSearch", studentSearch);
			request.getRequestDispatcher("/WEB-INF/views/student/getStudentAddrList.jsp").forward(request, response);
		}else if(studentSelect != null){
			studentAddrDao = new StudentAddrDao();
			
			int totalCurrentPage = 1;
			if(request.getParameter("currentPage") != null) {
				totalCurrentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			int totalCount  = studentAddrDao.countSearchStudentAddrList(studentSelect, studentSearch);
			int cutRow = 5;
			PageMaker pageMaker = new PageMaker(totalCount, cutRow, totalCurrentPage);
			
			ArrayList<Integer> pageNumber = new ArrayList<Integer>();
			for(int number = pageMaker.getStartPage(); number<=pageMaker.getEndPage(); number++) {
				pageNumber.add(number);
			}
			
			ArrayList<StudentAddr> list = studentAddrDao.searchStudentAddrList(studentSelect, studentSearch, pageMaker.getStartRow(), pageMaker.getCutRow());
			
			request.setAttribute("list", list);
			request.setAttribute("pageMaker", pageMaker);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("studentSelect", studentSelect);
			request.setAttribute("studentSearch", studentSearch);
			request.getRequestDispatcher("/WEB-INF/views/student/getStudentAddrList.jsp").forward(request, response);
		}
		
	}
}
