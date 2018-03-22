/*나윤주*/
package model;

public class Teacher {
	private int teacherNo;
	private String teacherId;
	private String teacherPw;
	private int teacherAddrCount;
	public int getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherPw() {
		return teacherPw;
	}
	public void setTeacherPw(String teacherPw) {
		this.teacherPw = teacherPw;
	}
	public int getTeacherAddrCount() {
		return teacherAddrCount;
	}
	public void setTeacherAddrCount(int teacherAddrCount) {
		this.teacherAddrCount = teacherAddrCount;
	}
	@Override
	public String toString() {
		return "Teacher [teacherNo=" + teacherNo + ", teacherId=" + teacherId + ", teacherPw=" + teacherPw
				+ ", teacherAddrCount=" + teacherAddrCount + "]";
	}
	
}
