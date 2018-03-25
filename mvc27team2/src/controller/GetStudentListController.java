package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageMaker;
import model.Student;
import model.StudentAddrDao;
import model.StudentDao;


@WebServlet("/getStudentListController.team2")
public class GetStudentListController extends HttpServlet {
	private StudentDao studentDao = null;
	private StudentAddrDao studentAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentDao = new StudentDao();
		studentAddrDao = new StudentAddrDao();
		
		int totalCurrentPage = 1;
		if(request.getParameter("currentPage") != null) {
			totalCurrentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int totalCount  = studentDao.countStudentListAll();
		int cutRow = 5;
		PageMaker pageMaker = new PageMaker(totalCount, cutRow, totalCurrentPage);
		
		ArrayList<Integer> pageNumber = new ArrayList<Integer>();
		for(int number = pageMaker.getStartPage(); number<=pageMaker.getEndPage(); number++) {
			pageNumber.add(number);
		}
		
		ArrayList<Student> list = studentDao.selectStudentList(pageMaker.getStartRow(), pageMaker.getCutRow());
		int studentAddrCount = 0;
		for(Student student : list) {
			studentAddrCount = studentAddrDao.countStudentAddrListOne(student.getStudentNo());
			student.setStudentAddrCount(studentAddrCount);
		}
		int sumCount = studentAddrDao.countStudentAddrListAll();
		request.setAttribute("sumCount", sumCount);
		request.setAttribute("list", list);
		request.setAttribute("pageMaker", pageMaker);
		request.setAttribute("pageNumber", pageNumber);
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentList.jsp").forward(request, response);
	}

}
