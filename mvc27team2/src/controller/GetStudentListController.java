package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int currentPage = 0;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else {
			currentPage = 1;
		}
		int pagePerRow = 10;
		int startRow = (currentPage - 1)*pagePerRow;
		int countStudentAddrListAll = studentDao.countStudentListAll();
		int lastPage = countStudentAddrListAll / pagePerRow;
		if(countStudentAddrListAll % pagePerRow != 0) {
			++lastPage;
		}
		ArrayList<Integer> pageNumber = new ArrayList<Integer>();
		for(int number = 1; number<=lastPage; number++) {
			pageNumber.add(number);
		}
		ArrayList<Student> list = studentDao.selectStudentList(startRow, pagePerRow);
		int studentAddrCount = 0;
		for(Student student : list) {
			studentAddrCount = studentAddrDao.countStudentAddrListOne(student.getStudentNo());
			student.setStudentAddrCount(studentAddrCount);
		}
		int sumCount = studentAddrDao.countStudentAddrListAll();
		request.setAttribute("sumCount", sumCount);
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("pageNumber", pageNumber);
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentList.jsp").forward(request, response);
	}

}
