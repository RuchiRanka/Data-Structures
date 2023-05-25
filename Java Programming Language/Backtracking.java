public class Backtracking {

    public static void printArr(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArr(int arr[], int i, int val) {

        // base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        // recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void findSubsets(String str, int i, String ans) {

        if (i == str.length()) {

            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        findSubsets(str, i + 1, ans + str.charAt(i));
        findSubsets(str, i + 1, ans);
    }

    public static void findPermutations(String str, String ans) {

        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursion
        for (int i = 0; i < str.length(); i++) {

            char curr = str.charAt(i);
            // "abcde" -> "ab" + "de" = "abde"
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutations(newStr, ans + curr);
        }
    }

    public static boolean isSafe(char chessBoard[][], int row, int col) {

        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard.length; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static int countTotalWays;

    public static void nQueenAllSoln(char chessBoard[][], int row) {

        if (row == chessBoard.length) {
            printBoard(chessBoard);
            countTotalWays++;
            return;
        }

        for (int j = 0; j < chessBoard.length; j++) {

            if (isSafe(chessBoard, row, j)) {

                chessBoard[row][j] = 'Q';
                nQueenAllSoln(chessBoard, row + 1); // function call
                chessBoard[row][j] = '_'; // backtracking step
            }
        }

    }

    public static boolean nQueenOneSoln(char chessBoard[][], int row) {

        // base case
        if (row == chessBoard.length) {
            return true;
        }

        for (int j = 0; j < chessBoard.length; j++) {

            if (isSafe(chessBoard, row, j)) {

                chessBoard[row][j] = 'Q';
                if (nQueenOneSoln(chessBoard, row + 1)) {
                    return true;
                }
                chessBoard[row][j] = '_';
            }
        }
        return false;
    }

    public static void printBoard(char board[][]) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // public static int gridWays(char board[][], int row, int col) {

    // //base case
    // if(row==board.length-1 && col==board[0].length-1) {
    // return 1;
    // }
    // else if(row == board.length || col == board[0].length) {
    // return 0;
    // }

    // int w1 = gridWays(board, row, col+1);
    // int w2 = gridWays(board, row+1, col);
    // return w1+w2;
    // }

    public static int gridWays(int n, int m, int row, int col) {

        // base case
        if (row == n - 1 && col == m - 1) {
            return 1;
        } else if (row == n || col == m) {
            return 0;
        }

        int w1 = gridWays(n, m, row, col + 1);
        int w2 = gridWays(n, m, row + 1, col);
        return w1 + w2;
    }

    public static boolean isSafe_sudoku(int sudoku[][], int row, int col, int j) {

        //same col
        for(int i=0; i<9; i++) {
            if(sudoku[i][col]==j) {
                return false;
            }
        }

        //same row
        for(int i=0; i<9; i++) {
            if(sudoku[row][i]==j) {
                return false;
            }
        }

        //same grid
        int gridRow = (row/3) * 3;
        int gridCol = (col/3) * 3;
        for(int i=gridRow; i<gridRow+3; i++) {
            for(int k=gridCol; k<gridCol+3; k++) {
                if(sudoku[i][k]==j) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {

        if(row==9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col+1;
        if(col==8) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        
        for (int j = 1; j <= 9; j++) {
            if(isSafe_sudoku(sudoku, row, col, j)) {
                sudoku[row][col] = j;
                if(sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;

    }

    public static void printSudoku(int sudoku[][]) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // int arr[] = new int[5];
        // changeArr(arr,0,1);
        // printArr(arr);

        // String str = "abc";
        // findSubsets(str, 0, "");
        // findPermutations(str, "");

        // int n = 4;
        // char chessBoard[][] = new char[n][n];
        // // initialize
        // for (int i = 0; i < chessBoard.length; i++) {
        // for (int j = 0; j < chessBoard.length; j++) {
        // chessBoard[i][j] = '_';
        // }
        // }

        // nQueenAllSoln(chessBoard, 0);
        // System.out.println("Total ways to solve N-Queens for n = " + n + " is " +
        // countTotalWays);

        // if(nQueenOneSoln(chessBoard, 0)) {
        // System.out.println("Solution is possible.");
        // printBoard(chessBoard);
        // } else {
        // System.out.println("Solution is not possible.");
        // }

        // int n=4, m=5;
        // // char board[][] = new char[n][m];
        // // System.out.println(gridWays(board, 0, 0));
        // System.out.println(gridWays(n, m, 0, 0));

        int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };
        if(sudokuSolver(sudoku,0,0)) {
            printSudoku(sudoku);
        }
        else {
            System.out.println("No solution");
        }
    }

}
