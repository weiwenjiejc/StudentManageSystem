package cn.sms.bean;

public class TeacherStudent {
	private Integer teacher_id;
	private String student_name;
	private String student_number;
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_number() {
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	@Override
	public String toString() {
		return "TeacherStudent [teacher_id=" + teacher_id + ", student_name=" + student_name + ", student_number="
				+ student_number + "]";
	}
	
	
}
