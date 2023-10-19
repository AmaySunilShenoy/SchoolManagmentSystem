package launcher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import modals.Admin;
import modals.Course;
import service.PayService;
import modals.Enrollment;
import modals.Student;

public class Launcher {
	public static void main(String[] args) throws ParseException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Admin admin = new Admin();
		admin.setAdminId("amay");
		admin.setPassword("amay12345");

		Course course = new Course();
		course.setCourseId("J2023");
		course.setCourseDuration(30);
		course.setCourseName("Java Application Development");

		Enrollment enroll = new Enrollment();
		enroll.setEnrollId(202301);
		enroll.setDate(sdf.parse("01/01/2023"));
		enroll.setDetails("Fall 2023 enrollment!");

		Student student = new Student();
		student.setStudId("F123");
		student.setName("Tom");
		student.setAge("20");
		student.setDepartment("Bachelor's of Computer Science");
		student.setYear("2023");

		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("python");
		courses.add("C++");
		student.setCourse(courses);

		PayService payService = new PayService();
		payService.read();

	}
}