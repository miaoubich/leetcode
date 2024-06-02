package net.misoubich.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student(1, "Ali", "Bouzar", 30, "Male", "System Information", 2017, "Korcula", 12),
				new Student(2, "Darin", "Bouzar", 26, "Female", "Computer Engineering", 2024, "Split", 67),
				new Student(3, "Lina", "Bouzar", 25, "Female", "Computer Engineering", 2022, "Dobrovnik", 164),
				new Student(4, "Ivan", "Prozuvic", 30, "Male", "Information Technology", 2017, "Zagreb", 116),
				new Student(5, "Dani", "Amine", 23, "Male", "Instrumentation Engineering", 2022, "Split", 19),
				new Student(6, "Sali", "Salim", 24, "Female", "Mechanical Engineering", 2023, "Zadar", 100),
				new Student(7, "Nawel", "Chaouche", 26, "Female", "Electronics Engineering", 2014, "Zagreb", 221),
				new Student(8, "Ismail", "Lake", 31, "Male", "Computer Engineering", 2014, "Zagreb", 523),
				new Student(9, "Kamel", "Shanfara", 27, "Male", "Computer Engineering", 2020, "Korcula", 17),
				new Student(10, "Rami", "Dan", 26, "Male", "Information Technology", 2017, "Split", 198));
		
		
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
//		avg.forEach((k,v)->System.out.println(k+": "+v));
		
		//8. Find the youngest student in all departments.
		Student young = students.stream().filter(s->s.getAge()==students.stream().mapToInt(Student::getAge).min().getAsInt()).findFirst().get();
		System.out.println("Youngest Student is: " + young);
		
		//9. Find the youngest studentByName by department
		
	}
}
