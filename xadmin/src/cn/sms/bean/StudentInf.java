package cn.sms.bean;

public class StudentInf {
	private String id;
	private String student_number;
	private String student_name;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudent_number() {
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "StudentInf [id=" + id + ", student_number=" + student_number + ", student_name=" + student_name
				+ ", password=" + password + "]";
	}
	
}
