package model;

public class TeacherAddr {
	private int teacherAddrNo;
	private int teacherNo;
	private String teacherId;
	private String address;
	public int getTeacherAddrNo() {
		return teacherAddrNo;
	}
	public void setTeacherAddrNo(int teacherAddrNo) {
		this.teacherAddrNo = teacherAddrNo;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "TeacherAddr [teacherAddrNo=" + teacherAddrNo + ", teacherNo=" + teacherNo + ", teacherId=" + teacherId
				+ ", address=" + address + "]";
	}

}
