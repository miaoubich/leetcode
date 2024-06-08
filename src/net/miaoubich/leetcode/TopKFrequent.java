package net.miaoubich.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

	public static void main(String[] args) {
		 int[] nums = {1,1,1,2,2,3};
		 int k = 2;
		System.err.println(Arrays.toString(topKFrequent(nums, k)));
	}

	/*
	 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
	 */
	public static int[] topKFrequent(int[] nums, int k) {
	    Map<Integer, Integer> frequencyMap = new HashMap<>();
	    for (int num : nums) {
	        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
	    }

	    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
	        (a, b) -> a.getValue() - b.getValue());

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
