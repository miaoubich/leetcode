package net.miaoubich.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ToSum {

	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 4, 8, 6}; int target = 11;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int result = target - nums[i];
            if(map.containsKey(result)){
                return new int[]{i, map.get(result)};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
