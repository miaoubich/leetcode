package net.misoubich.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseIntegerList {

	public static void main(String[] args) {
		Integer[] arr = { 5, 4, 3, 2, 1 };
		List<Integer> list = new ArrayList<>(Arrays.asList(arr));

		System.out.println(reverseList(list));
		System.out.println(Arrays.toString(reverseArray(arr)));
		System.out.println("Print original list: ");
		System.out.println(Arrays.toString(listToArrayReversed(list)));
		System.out.println(ArrayToListRevers(arr));

	}

	public static List<Integer> reverseList(List<Integer> l) {
		Collections.reverse(l);
		return l;
	}

	public static int[] reverseArray(Integer[] arr) {
		return IntStream.range(0, arr.length).map(i -> arr[arr.length - i - 1]).toArray();
	}

	public static int[] listToArrayReversed(List<Integer> l) {
		Integer[] arr = l.toArray(new Integer[0]);
		int[] revArr = IntStream.range(0, l.size()).map(i -> arr[l.size() - i - 1]).toArray();
		return revArr;
	}
	
	public static List<Integer> ArrayToListRevers(Integer[] arr){
		List<Integer> list = Arrays.asList(arr);//.stream().mapToInt(Integer::intValue).boxed().collect(Collectors.toList());
		Collections.reverse(list);
		return list;
	}
}
