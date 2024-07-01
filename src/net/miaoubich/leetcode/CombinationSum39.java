package net.miaoubich.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * */
public class CombinationSum39 {

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(combinationSum(candidates, target));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null)
			return null;

		List<List<Integer>> result = new ArrayList<>();

		findCombinations(candidates, 0, target, new ArrayList<>(), result);

		return result;
	}

	private static void findCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				current.add(candidates[i]);
				findCombinations(candidates, i, target - candidates[i], current, result);
				current.remove(Integer.valueOf(candidates[i]));
			}
		}
	}
}
