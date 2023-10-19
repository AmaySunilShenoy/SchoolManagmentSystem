package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modals.Student;

public class PayService {	
	
	public List<Student> read() throws IOException{
	String line = null;
	String splitBy = ",";
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\earuvai\\Desktop\\students.csv"));
	List<Student> studentList = new ArrayList<>();
	int count = 0;
	while((line = br.readLine()) != null) {
		if(count != 0) {
			String[] Student = line.split(splitBy);
			
			Student student = new Student();
			String a = Student[4].trim();
			if (a != "") {
				a = (Integer.valueOf(Student[4].trim()) >= 19) ? Student[4].trim(): String.valueOf(0);
			}
			
			student.setStudId(Student[0].trim());
			student.setName(Student[1].trim());
			student.setDepartment(Student[2].trim());

			String CSV = Student[3].trim();
			String[] values = CSV.split(",");
			
	        student.setCourse(Arrays.asList(values));
			student.setAge(Student[4].trim());
			student.setYear(Student[5].trim());
			double fee = Double.parseDouble(Student[6].trim());
			student.setFee(fee);
			student.setPaid(Student[7].trim());
			if(Student[7].trim() != null && !Student[7].trim().isEmpty()) {
				student.setPaid(Student[7].trim());
			}
			studentList.add(student);			
		}
		count ++;
		
	}
	br.close();
	return studentList;
}
}