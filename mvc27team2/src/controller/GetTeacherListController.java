package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherAddrDao;
import model.TeacherDao;

@WebServlet("/getTeacherListController.team2")
public class GetTeacherListController extends HttpServlet {
	private TeacherDao teacherDao = null;
	private TeacherAddrDao teacherAddrDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		teacherDao = new TeacherDao();
		teacherAddrDao = new TeacherAddrDao();
		ArrayList<Teacher> list = teacherDao.selectTeacherList();
		int teacherAddrCount = 0;
		for(Teacher teacher : list) {
			teacherAddrCount = teacherAddrDao.countTeacherAddrList();
			teacher.setTeacherAddrCount(teacherAddrCount);
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/teacher/getTeacherList.jsp").forward(request, response);
	}
}