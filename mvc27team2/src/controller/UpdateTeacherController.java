package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;

@WebServlet("/updateTeacherController.team2")
public class UpdateTeacherController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		//해당하는 Dao 실행문 호출
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.selectTeacherOne(teacherNo);
		//속성값을 셋팅.
		request.setAttribute("teacher", teacher);
		//
		request.getRequestDispatcher("/WEB-INF/views/teacher/updateTeacher.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 화면에 입력한 값을 이클립스에 설정한 인코딩값에 맞추기위한 셋팅작업.
		request.setCharacterEncoding("utf8");
		//사용자가 화면에 입력한 값을 받는다.
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		//mysql에 보내기위해 받아온 값을 dto에 값을 다시 셋팅
		Teacher teacher = new Teacher();
		teacher.setTeacherNo(teacherNo);
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		//해당하는 dao 실행문 호출
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.updateTeacher(teacher);
		//넘겨줄 페이지 경로.
		response.sendRedirect(request.getContextPath()+"/getTeacherListController.team2");
	}
}