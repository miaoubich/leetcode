package net.miaoubich.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequent {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		System.err.println(Arrays.toString(topKFrequent(nums, k)));
	}

	/*
	 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
	 */
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Long> map = Arrays.stream(nums)
				                       .boxed()//The boxed() method in Java is used to convert a stream of primitive data types 
				                               //(like IntStream, LongStream, DoubleStream) to a stream of their corresponding 
				                               //wrapper objects (like Stream<Integer>, Stream<Long>, Stream<Double>).
				                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		List<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys, (k1, k2) -> Long.compare(map.get(k2), map.get(k1)));
		
		return keys.stream().mapToInt(i->i).limit(k).toArray();
	}

	public static int[] topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			minHeap.offer(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = minHeap.poll().getKey();
		}

		return result;
	}

}
