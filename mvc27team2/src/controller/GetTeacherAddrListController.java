package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/getTeacherAddrListController.team2")
public class GetTeacherAddrListController extends HttpServlet {
	private TeacherAddrDao teacherAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		teacherAddrDao = new TeacherAddrDao();

		int totalRowCount = teacherAddrDao.teacherAddrRowCount();
		System.out.println(totalRowCount+":totalRowCount");
		int pagePerRow = 10; // 요청페이지에서 받을 수도 있습니다.
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
				System.out.println("currentPage:"+currentPage);
		}

		int startRow = (currentPage-1)*pagePerRow;

		ArrayList<TeacherAddr> list = teacherAddrDao.selectTeacherAddrList(startRow, pagePerRow);
		
		int lastPage = totalRowCount / pagePerRow;
		System.out.println("lastPage:"+lastPage);

		if(totalRowCount % pagePerRow != 0) {
			lastPage++;
			System.out.println("lastPage2:"+lastPage);
		}

		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/teacher/getTeacherAddrList.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	teacherAddrDao = new TeacherAddrDao();
	
	}
}
