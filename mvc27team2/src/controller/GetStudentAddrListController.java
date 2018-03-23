/*나성수*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;

@WebServlet("/getStudentAddrListController.team2")
public class GetStudentAddrListController extends HttpServlet {
	private StudentAddrDao studentAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String studentSelect = request.getParameter("studentSelect");
		String studentSearch = request.getParameter("studentSearch");
		if(studentSelect == null && studentSearch == null || studentSearch == "") {
			studentAddrDao = new StudentAddrDao();
			int currentPage = 0;
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}else {
				currentPage = 1;
			}
			int pagePerRow = 10;
			int startRow = (currentPage - 1)*pagePerRow;
			int countStudentAddrListAll = studentAddrDao.countStudentAddrListAll();
			int lastPage = countStudentAddrListAll / pagePerRow;
			if(countStudentAddrListAll % pagePerRow != 0) {
				++lastPage;
			}
			ArrayList<Integer> pageNumber = new ArrayList<Integer>();
			for(int number = 1; number<=lastPage; number++) {
				pageNumber.add(number);
			}
			ArrayList<StudentAddr> list = studentAddrDao.selectStudentAddrList(startRow, pagePerRow);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("studentSelect", studentSelect);
			request.setAttribute("studentSearch", studentSearch);
			request.getRequestDispatcher("/WEB-INF/views/student/getStudentAddrList.jsp").forward(request, response);
		}else {
			studentAddrDao = new StudentAddrDao();
			int currentPage = 0;
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}else {
				currentPage = 1;
			}
			int pagePerRow = 10;
			int startRow = (currentPage - 1)*pagePerRow;
			int countSearchStudentAddrList = studentAddrDao.countSearchStudentAddrList(studentSelect, studentSearch);
			int lastPage = countSearchStudentAddrList / pagePerRow;
			if(countSearchStudentAddrList % pagePerRow != 0) {
				++lastPage;
			}
			ArrayList<Integer> pageNumber = new ArrayList<Integer>();
			for(int number = 1; number<=lastPage; number++) {
				pageNumber.add(number);
			}
			ArrayList<StudentAddr> list = studentAddrDao.searchStudentAddrList(studentSelect, studentSearch, startRow, pagePerRow);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("studentSelect", studentSelect);
			request.setAttribute("studentSearch", studentSearch);
			request.getRequestDispatcher("/WEB-INF/views/student/getStudentAddrList.jsp").forward(request, response);
		}
		
	}
}
