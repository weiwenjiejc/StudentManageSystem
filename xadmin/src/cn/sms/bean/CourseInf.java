package cn.sms.bean;

public class CourseInf {
	private Integer id;
	private String course_number;
	private String course_name;
	private String course_desc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCourse_desc() {
		return course_desc;
	}
	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}
	@Override
	public String toString() {
		return "CourseInf [id=" + id + ", course_number=" + course_number + ", course_name=" + course_name
				+ ", course_desc=" + course_desc + "]";
	}

	
	
}
