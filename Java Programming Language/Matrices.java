import java.util.*;

public class Matrices {
    
    public static boolean search(int matrix[][], int key){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == key){
                    System.out.println(matrix[i][j] + " found at " + "(" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Key not found.");
        return false;
    }

    public static void largest(int matrix[][]){
        int max = Integer.MIN_VALUE;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                max = Math.max(max,matrix[i][j]);
            }
        }
        System.out.println(max + " is the largest element of the given matrix.");
    }

    public static void smallest(int matrix[][]){
        int min = Integer.MAX_VALUE;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                min = Math.min(min,matrix[i][j]);
            }
        }
        System.out.println(min + " is the smallest element of the given matrix.");
    }

    public static void spiralMatrix(int matrix[][]){

        int startRow = 0;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol){
            
            //top
            for(int i=startCol; i<=endCol; i++){
                System.out.print(matrix[startRow][i] + " ");
            }

            //right
            for(int i=startRow+1; i<endRow; i++){
                System.out.print(matrix[i][endCol] + " ");
            }

            //bottom
            for(int i=endCol; i>startCol; i--){
                System.out.print(matrix[endRow][i] + " ");
            }

            //left
            for(int i=endRow; i>startRow; i--){
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }

    public static void diagonalSum(int matrix[][]){

        int pd = 0, sd = 0, m = matrix.length-1;
        for(int i=0; i<matrix.length; i++){
            pd += matrix[i][i];
            
            if( m != i){
                sd += matrix[i][m];
            }
            m--;
        }
        System.out.println(sd+pd);
    }

    public static boolean staircaseSearch(int matrix[][], int key){

        int row=0, col=matrix[0].length-1;
        
        while(row<=matrix.length-1 && col>=0){

            if(matrix[row][col] == key){
                System.out.println("Key is found at (" + row + "," + col + ")");
                return true;
            }
            else if(key<matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }

        System.out.println("Key not found");
        return false;
    }

    public static void main(String args[]){
        // int matrix[][] = new int[3][3];
        // int n = matrix.length, m = matrix[0].length;

        // //input
        // Scanner sc = new Scanner(System.in);
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        // //output
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // search(matrix,6);
        // largest(matrix);
        // smallest(matrix);

        // int matrix[][] = {{1,2,3,4},
        //                   {5,6,7,8},
        //                   {9,10,11,12},
        //                   {13,14,15,16}};

        int matrix[][] = {{1,2,3},
                          {5,6,7},
                          {9,10,11}};

        // int matrix[][] = {{1,2,3,4,5},
        //                   {6,7,8,9,10},
        //                   {11,12,13,14,15},
        //                   {16,17,18,19,20},
        //                   {21,22,23,24,25}};

        // spiralMatrix(matrix);
        // diagonalSum(matrix);
        staircaseSearch(matrix,9);

    }
}
