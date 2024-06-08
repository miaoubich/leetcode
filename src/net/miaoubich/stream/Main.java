package net.miaoubich.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
				new Student(7, "Nawel", "Chaouche", 36, "Female", "Electronics Engineering", 2014, "Zagreb", 221),
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
		//Student young = students.stream().filter(s->s.getAge()==students.stream().mapToInt(Student::getAge).min().getAsInt()).findFirst().get();
		//or
		Student young = students.stream().min(Comparator.comparing(Student::getAge)).get();
//		System.out.println("Youngest Student is: " + young);
		
		//9. Find the youngest studentByName by department
		Map<String, List<Student>> youngestStudentByDepartment = students.stream().collect(
																Collectors.groupingBy(Student::getDepartmentName));
//		youngestStudentByDepartment.forEach((k,v)->{
//			int minAge = v.stream().mapToInt(Student::getAge).min().getAsInt();
//			System.out.println(k+": "+minAge);
//		});
		//or
		Map<String, Integer> youngestStudentByDepartment1 = students.stream()
		        .collect(Collectors.groupingBy(Student::getDepartmentName,
		                Collectors.collectingAndThen(
		                        Collectors.minBy(Comparator.comparingInt(Student::getAge)),
		                        youngestStudent -> youngestStudent.map(Student::getAge).orElse(0))));

//		youngestStudentByDepartment1.forEach((department, minAge) ->
//		        System.out.println(department + ": " + minAge));
		
//		10. Find the senior female student in all departments.
		Student oldestFemale = students.stream().filter(s->s.getGender().equals("Female")).max(Comparator.comparing(Student::getAge)).get();
//		System.out.println(oldestFemale);
		
//		11. Find the list of students whose rank is between 50 and 100.
		List<Student> studts = students.stream().filter(s->(s.getRank()>=50 && s.getRank()<=100)).toList();
//		studts.forEach(s->System.out.println(s));
		
//		12. Find the department who is having maximum number of students.
		Map<String, Long> dprtmts = students.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
		Collection<Long> values = dprtmts.values();
		Long max = values.stream().max(Comparator.comparing(Long::longValue)).get();
//		for(Map.Entry<String, Long> en: dprtmts.entrySet()) {
//			if(en.getValue() == max)
//				System.out.println(en.getKey());
//		}
		//or
		String dprtmts2 = students.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
//		System.out.println(dprtmts2);
		
		//13. Find the Students who stays in Zagreb and sort them by their firstNames.
		List<Student> studentsZagrebByFirstName = students.stream().filter(s->s.getCity().equals("Zagreb"))
						 .sorted(Comparator.comparing(Student::getFirstName)).toList();
//		studentsZagrebByFirstName.forEach(s->System.out.println(s));
		
		//14. Find the total count of students.
		Long count = students.stream().count();
//		System.out.println(count);
		
		//15. Find the average rank in all departments.
		Double avgRank = students.stream().mapToDouble(Student::getRank).average().getAsDouble();
//		System.out.println("avgRank: " + avgRank);
		
		//16. Group average rank of students by department
		Map<String, Double> avgRankByDepartment = students.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingDouble(Student::getRank)));
//		avgRankByDepartment.forEach((k,v)->System.out.println(k+": "+v));
		
		//17. Find the highest rank in each department.
		Map<String, Optional<Student>> maxRankByDepart = students.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.maxBy(Comparator.comparing(Student::getRank))));
//		maxRankByDepart.forEach((k,v)->System.out.println(k+": "+v.get()));
		
		//18. Find the list of students , which are sorted by their rank in reverse order.
		List<Student> sortByRank = students.stream().sorted(Comparator.comparing(Student::getRank).reversed()).toList();
//		sortByRank.forEach(s->System.out.println(s));
		
		//19. Find the second highest rank student.
		Student seconfHighest = students.stream().sorted(Comparator.comparing(Student::getRank).reversed()).skip(1).findFirst().get();
//		System.out.println(seconfHighest);
		
		//20. Find the ranks of students by department in ascending order.
		Map<String, List<Integer>> sortedRanksByDeprt = students.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName, 
						Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted(Comparator.comparing(Student::getRank)).map(Student::getRank).toList())));
		sortedRanksByDeprt.forEach((k,v)->System.out.println(k+": "+v));
	}
}
