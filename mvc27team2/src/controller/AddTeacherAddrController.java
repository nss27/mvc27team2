package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherAddr;
import model.TeacherAddrDao;
import model.TeacherDao;


@WebServlet("/addTeacherAddrController.team2")
public class AddTeacherAddrController extends HttpServlet {
	 private TeacherDao teacherDao = null;
	 private TeacherAddrDao teacherAddrDao = null;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//teacherNo값을 가져온다.
		int teacherNo=Integer.parseInt(request.getParameter("teacherNo"));
		// 여기서만 사용할 것이기 때문에 this를 사용해 지정해주고 실행.
		teacherDao = new TeacherDao();
		teacherAddrDao = new TeacherAddrDao();
		Teacher teacher = teacherDao.selectTeacherOne(teacherNo); 
		//화면에서 불러올 id, no의 속성값을 셋팅해준다.
		request.setAttribute("teacherNo", teacher.getTeacherNo());
		request.setAttribute("teacherId", teacher.getTeacherId());
		int count = teacherAddrDao.countTeacherAddrList(teacherNo);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacherAddr.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		//addTeacherAddr 폼에서 보낸것을 받아온다. 그래서 getParameter를 사용.
		int teacherNo = Integer.parseInt(request.getParameter("teacherNo"));
		String address = request.getParameter("address");
		//참조변수 선언을 해서 주소를 불러온다. 담을공간을 준비
		TeacherAddr teacherAddr = new TeacherAddr();
		teacherAddr.setTeacherNo(teacherNo);
		teacherAddr.setAddress(address);
		//메소드를 사용하기 위해 Dao 호출
		teacherAddrDao = new TeacherAddrDao();
		teacherAddrDao.insertTeacherAddr(teacherAddr);
		//리다이렉트를 해서 화면을 보여주기위해 경로 요청
		response.sendRedirect(request.getContextPath()+"/getTeacherAddrListController.team2");
	}
}
