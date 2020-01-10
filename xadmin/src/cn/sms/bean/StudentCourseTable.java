package cn.sms.bean;

public class StudentCourseTable {
	private Integer student_id;
	private String student_number;
	private Integer teacher_id;
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getStudent_number() {
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	@Override
	public String toString() {
		return "StudentCourseTable [student_id=" + student_id + ", student_number=" + student_number + ", teacher_id="
				+ teacher_id + "]";
	}
	
}
