package net.misoubich.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student(1, "Aditya", "Mall", 30, "Male", "Mechanical Engineering", 2014, "Mumbai", 122),
				new Student(2, "Pulkith", "Singh", 26, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankita", "Patil", 25, "Female", "Computer Engineering", 2019, "Kerala", 164),
				new Student(4, "Satish", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Darshan", "Mukd", 23, "Male", "Instrumentation Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student(10, "Satyam", "Pandey", 26, "Male", "Biotech Engineering", 2017, "Mumbai", 98));
		
		
		//1. Group the students by department names.
		Map<String, List<Student>> studentsByDepartment = students.stream().collect(Collectors.groupingBy(Student::getDepartmentName));
//		for(Map.Entry<String, List<Student>> entry: studentsByDepartment.entrySet())
//			System.out.println(entry);
//		studentsByDepartment.forEach((k, v) -> System.out.println(k+": "+v));
		
		//2. Group the students ids by department names.
		Map<String, List<Integer>> studentsIdsByDepartment = students.stream().collect(Collectors.groupingBy(
				Student::getDepartmentName, Collectors.mapping(Student::getId, Collectors.toList())));
//		for(Map.Entry<String, List<Integer>> entry: studentsIdsByDepartment.entrySet())
//			System.out.println(entry);
		
		
		//3. Group the number of students by departmentName
		Map<String, Long> studentsCountByDepartmentName = students.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
//		studentsCountByDepartmentName.forEach((k,v)->System.out.println(k+": "+v));
		
		//4. Find all departments names.
//		Set<String> departments = students.stream().map(Student::getDepartmentName).collect(Collectors.toSet());
		//or
		List<String> departments = students.stream().map(Student::getDepartmentName).distinct().collect(Collectors.toList());
//		System.out.println(departments);
		
		//5. Find the list of students whose age is less than 25.
		List<Student> studentsLessThan25 = students.stream().filter(s->s.getAge()<25).collect(Collectors.toList());
//		studentsLessThan25.forEach(s->System.out.println(s));
		
		//6. Find the max age of students.
		int maxAge = students.stream().mapToInt(Student::getAge).max().getAsInt();
//		System.out.println("Max AGE: " + maxAge);
		
		//7.  Find the average age of male and female students.
		Map<String, Double> avg = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
		avg.forEach((k,v)->System.out.println(k+": "+v));
	}
}
