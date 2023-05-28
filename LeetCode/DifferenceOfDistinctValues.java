//2711. Difference of Number of Distinct Values on Diagonals

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int ans[][] = new int[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int topLeft=0;
                int bottomRight=0;
                
                if((i==0 && j==n-1) || (i==m-1 && j==0)) {
                    topLeft = 0;
                    bottomRight = 0;
                }
                else if(i==0 || j==0) {
                    int iTemp = i, jTemp = j;
                    ArrayList<Integer> arr2 = new ArrayList<>();
                    while(iTemp+1<m && jTemp+1<n) {
                        if(!arr2.contains(grid[iTemp+1][jTemp+1])) {
                            arr2.add(grid[iTemp+1][jTemp+1]);
                        }
                        iTemp++; jTemp++;
                    }
                    bottomRight = arr2.size();
                }
                else if(i==m-1 || j==n-1) {
                    int iTemp = i, jTemp = j;
                    ArrayList<Integer> arr1 = new ArrayList<>();
                    while(iTemp-1>=0 && jTemp-1>=0) {
                        if(!arr1.contains(grid[iTemp-1][jTemp-1])) {
                            arr1.add(grid[iTemp-1][jTemp-1]);
                        }
                        iTemp--; jTemp--;
                    }
                    topLeft = arr1.size();
                    
                }
                else {
                    int iTemp = i, jTemp = j;
                    ArrayList<Integer> arr1 = new ArrayList<>();
                    while(iTemp-1>=0 && jTemp-1>=0) {
                        if(!arr1.contains(grid[iTemp-1][jTemp-1])) {
                            arr1.add(grid[iTemp-1][jTemp-1]);
                        }
                        iTemp--; jTemp--;
                    }
                    topLeft = arr1.size();
                    
                    iTemp = i; jTemp = j;
                    ArrayList<Integer> arr2 = new ArrayList<>();
                    while(iTemp+1<m && jTemp+1<n) {
                        if(!arr2.contains(grid[iTemp+1][jTemp+1])) {
                            arr2.add(grid[iTemp+1][jTemp+1]);
                        }
                        iTemp++; jTemp++;
                    }
                    bottomRight = arr2.size();
                }
                
                ans[i][j] = Math.abs(topLeft-bottomRight);
            }
        }
        return ans;
    }
}
