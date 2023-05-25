//59. Spiral Matrix II

class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int count = 1;
        int start = 0, end = n-1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                for(int k=start; k<end; k++) {
                    ans[start][k] = count++;
                }
                for(int k=start; k<end; k++) {
                    ans[k][end] = count++;
                }
                for(int k=end; k>start; k--) {
                    ans[end][k] = count++;
                }
                for(int k=end; k>start; k--) {
                    ans[k][start] = count++;
                }

                start++;
                end--;
            }
        }

        if(n % 2 != 0) {
            int mid = n/2;
            ans[mid][mid] = count++;
        }
        return ans;
    }
}
