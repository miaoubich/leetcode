package net.miaoubich.leetcode;

import java.util.Arrays;

public class ContainsDuplicates {

	public static void main(String[] args) {
		int[] nums = {1,2,3,2,5,4,1,6,9,8,5};
		int[] nums1 = {1,2,34,8,9};
		System.out.println(containsDuplicate(nums1));
	}
	
	 public static boolean containsDuplicate(int[] nums) {
	        int[] distictNums = Arrays.stream(nums).distinct().toArray();

	        return nums.length != distictNums.length;
	    }
}
