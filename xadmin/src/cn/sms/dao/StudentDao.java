package cn.sms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.sms.bean.TeacherCourse;
import cn.sms.bean.StudentCourseTable;
import cn.sms.bean.StudentInf;

public interface StudentDao {

	@Select("SELECT" + "	teacher_id," + "	a.teacher_number," + "	teacher_name," + "	a.course_number,"
			+ "	course_name," + "	total," + "	surplus " + "FROM"
			+ "	( teacher_course a INNER JOIN teacher_inf b ON a.teacher_number = b.teacher_number )"
			+ "	INNER JOIN course_inf c ON a.course_number = c.course_number")
	List<TeacherCourse> listAllCourse();

	@Select("insert into student_course (student_number,teacher_id) values(#{student_number},#{teacher_id})")
	Integer OrderCourse(@Param("student_number") String student_number, @Param("teacher_id") Integer teacher_id);

	@Select("select * from student_inf where student_number=#{student_number}")
	StudentInf getInfByStudnetNumber(String student_number);

	@Select("select teacher_id from student_course where student_number=#{student_number}")
	List<Integer> getCourseByStudentNumber(String student_number);

	@Select("select count(*) from student_course where student_number=#{student_number}")
	Integer getSelectedCourseCount(String student_number);

	@Delete("delete from student_course where student_number=#{student_number} and teacher_id=#{teacher_id}")
	Integer unOrderCourse(@Param("student_number") String student_number, @Param("teacher_id") Integer teacher_id);

	@Select("select * from student_inf")
	List<StudentInf> listAllStudent();

	@Select("select count(*) from student_inf")
	Integer getCount();

	@Select("select * from student_course where student_number=#{student_number} and teacher_id=#{teacher_id}")
	StudentCourseTable isHaveSelected(@Param("student_number") String student_number,
			@Param("teacher_id") Integer teacher_id);

	@Delete("delete from student_inf where student_number=#{student_number}")
	Integer delStudent(String student_number);

	@Update("update student_inf set student_name=#{student_name},password=#{password} where student_number=#{student_number}")
	Integer updateStudent(StudentInf studentInf);

	@Insert("insert into student_inf(student_number,student_name,password)values(#{student_number},#{student_name},#{password})")
	Integer addStudent(StudentInf studentInf);
}
