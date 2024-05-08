package net.misoubich.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseIntegerList {

	public static void main(String[] args) {
		Integer[] arr = {5,4,3,2,1};
		List<Integer> list = new ArrayList<>(Arrays.asList(arr));
		
		System.out.println(reverseList(list));
		System.out.println(Arrays.toString(reverseArray(arr)));
		
		
	}

	public static List<Integer> reverseList(List<Integer> l) {
	        Collections.reverse(l);
	        return l;
	}
	
	public static int[] reverseArray(Integer[] arr) {
		return IntStream.range(0, arr.length).map(i -> arr[arr.length-i-1]).toArray();
	}
}
