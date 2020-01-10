package cn.sms.bean;

import java.io.Serializable;

public class TeacherCourseTable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String teacher_id;
	private String teacher_number;
	private String course_number;
	private Integer total;
	private Integer surplus;
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
	public String getCourse_number() {
		return course_number;
	}
	public void setCourse_number(String course_number) {
		this.course_number = course_number;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSurplus() {
		return surplus;
	}
	public void setSurplus(Integer surplus) {
		this.surplus = surplus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TeacherCourseTable [teacher_id=" + teacher_id + ", teacher_number=" + teacher_number
				+ ", course_number=" + course_number + ", total=" + total + ", surplus=" + surplus + "]";
	}
	
	
}
