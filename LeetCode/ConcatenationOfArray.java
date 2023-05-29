//1929. Concatenation of Array

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2*n];
        for(int i=0, j=n; i<n; i++, j++) {
            ans[i]=ans[j]=nums[i];
        }
        return ans;
    }
}