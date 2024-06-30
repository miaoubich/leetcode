package net.miaoubich.sql2java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SqlToJava8 {

	public static void main(String[] args) {
		List<Staff> staffList = Arrays.asList(
                new Staff("B003", "SG37", 12000.00),
                new Staff("B003", "SG14", 18000.00),
                new Staff("B003", "SG5", 24000.00),
                new Staff("B005", "SL21", 30000.00),
                new Staff("B005", "SL41", 9000.00),
                new Staff("B007", "SA9", 9000.00)
        );
		sqlToJava(staffList);

	}

	/*
	 * SELECT branchNo, COUNT(staffNo) AS myCount, SUM(salary) AS mySum
		FROM Staff
		GROUP BY branchNo
		ORDER BY branchNo;

	 * */
	public static void sqlToJava(List<Staff> staffList) {
		Map<String, List<Staff>> map = staffList.stream()
						.collect(Collectors.groupingBy(Staff::getBranchNo));
		
		map.entrySet().forEach(System.out::println);
	}
}
