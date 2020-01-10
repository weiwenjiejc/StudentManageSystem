package cn.sms.dao.provider;

import org.apache.ibatis.jdbc.SQL;

public class StudentSqlProvider {
	
	public String listAllCourse() {
		return new SQL() {
		}.toString();
	}
}
