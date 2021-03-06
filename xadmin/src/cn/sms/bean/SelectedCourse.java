package cn.sms.bean;

public class SelectedCourse {
	private static final long serialVersionUID = 1L;
	private String teacher_id;
	private String teacher_number;
	private String teacher_name;
	private String course_number;
	private String course_name;
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
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
	public String getCourse_number() {
		return course_number;
	}
	public void setCourse_number(String course_number) {
		this.course_number = course_number;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SelectedCourse [teacher_id=" + teacher_id + ", teacher_number=" + teacher_number + ", teacher_name="
				+ teacher_name + ", course_number=" + course_number + ", course_name=" + course_name + "]";
	}
	
}
