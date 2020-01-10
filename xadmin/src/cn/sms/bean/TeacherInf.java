package cn.sms.bean;

public class TeacherInf {
	private String id;
	private String teacher_number;
	private String teacher_name;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeacher_number() {
		return teacher_number;
	}
	public void setTeacher_number(String teacher_number) {
		this.teacher_number = teacher_number;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "TeacherInf [id=" + id + ", teacher_number=" + teacher_number + ", teacher_name=" + teacher_name
				+ ", password=" + password + "]";
	}
	
	
}
