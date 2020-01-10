package cn.sms.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import cn.sms.bean.TeacherInf;

public class TeacherSqlProvider {
	// 动态插入
	public String insertTeacher(TeacherInf teacher) {

		return new SQL() {
			{
				INSERT_INTO("teacher_inf");
				if (teacher.getTeacher_number() != null && !teacher.getTeacher_number().equals("")) {
					VALUES("teacher_number", "#{teacher_number}");
				}
				if (teacher.getTeacher_name() != null && !teacher.getTeacher_name().equals("")) {
					VALUES("teacher_name", "#{teacher_name}");
				}
				if (teacher.getPassword() != null && !teacher.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateTeacher(TeacherInf teacher) {

		return new SQL() {
			{
				UPDATE("teacher_inf");
				/*
				 * if (teacher.getTeacher_number() != null) { SET("teacher_number",
				 * "#{teacher_number}"); }
				 */
				if (teacher.getTeacher_name() != null) {
					SET("teacher_name", "#{teacher_name}");
				}
				if (teacher.getPassword() != null) {
					SET("password", "#{password}");
				}
				WHERE(" teacher_number = #{teacher_number} ");
			}
		}.toString();
	}
}
