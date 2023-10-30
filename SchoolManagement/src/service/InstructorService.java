package service;

import java.util.List;
import java.math.BigInteger;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import modals.Instructors;

public class InstructorService {
	public List<Instructors> readCSV () throws IOException{
		String line = null;
		String splitBy = ",";
		int count = 0;
		BufferedReader br =  new BufferedReader (new FileReader ("C:\\Users\\sheno\\Desktop\\instructors.csv"));
		List<Instructors> instructorList = new ArrayList<>();
		
		while((line = br.readLine()) != null) {
			if(count != 0) {
				Instructors instructor = new Instructors();
				String[] instructors = line.split(splitBy);
				
				instructor.setInstructorId(instructors[0].trim());
				instructor.setName(instructors[1].trim());
				instructor.setSubject(instructors[2].trim());
				
				String subject = instructors[2].trim();
				if(subject.equals("C++")) {
					instructor.setSubject("JavaScript");
				}
				
				instructor.setPhoneNumber(new BigInteger(instructors[3].trim()));
				instructor.setEmail(instructors[4].trim());
				instructor.setTargetYear(instructors[5].trim());
				
				instructorList.add(instructor);
				
				
			}
		}
	br.close();
	return instructorList;
}
}
