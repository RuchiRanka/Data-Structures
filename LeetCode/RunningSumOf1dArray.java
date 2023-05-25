//1480. Running Sum of 1d Array

class Solution {
    public int[] runningSum(int[] nums) {
        int prev = 0;
        for(int i=1; i<nums.length; i++) {
            prev = nums[i-1];
            nums[i] += prev;
        }
        return nums;
    }
}