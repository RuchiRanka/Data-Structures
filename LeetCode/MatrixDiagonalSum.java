//1572. Matrix Diagonal Sum

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int i=0, j=mat.length-1;
        while(i<mat.length && j>=0) {
            sum+=mat[i][j];
            i++;
            j--;
        }

        for(int k=0; k<mat.length; k++) {
            sum+=mat[k][k];
        }

        if(mat.length%2!=0) {
            int index = mat.length/2;
            sum -= mat[index][index];
        }
        return sum;
    }
}
