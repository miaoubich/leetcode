package net.miaoubich.leetcode;

import java.util.Arrays;

public class ContainsDuplicates {

	public static void main(String[] args) {
		
	}
	
	 public static boolean containsDuplicate(int[] nums) {
	        int[] distictNums = Arrays.stream(nums).distinct().toArray();

	        return nums.length != distictNums.length;
	    }
}
