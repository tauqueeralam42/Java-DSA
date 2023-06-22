public class Sudoku {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // row
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        // column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit)
                    return false;
            }
        }

        return true;
    }

    public static boolean solveSudoku(int sudoku[][], int row, int col) {
        if (row == 9) {
            
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(sudoku, row, col, i)) {
                sudoku[row][col] = i;
                if (solveSudoku(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            if(i%3==0){
                    for(int k=0; k<9; k++)
                    System.out.print("---");
                    System.out.println();
                }
            for (int j = 0; j < 9; j++) {
                if(j==3 || j==6){
                    System.out.print("| ");
                }
                if(j==0)
                    System.out.print("   ");
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = { { 0, 8, 3, 2, 7, 0, 5, 0, 0 },
                { 0, 0, 0, 8, 5, 4, 1, 9, 0 },
                { 0, 0, 1, 6, 0, 0, 0, 0, 0 },
                { 0, 9, 0, 0, 0, 0, 0, 4, 8 },
                { 0, 1, 5, 9, 4, 0, 0, 0, 2 },
                { 2, 0, 8, 0, 6, 7, 9, 0, 0 },
                { 0, 0, 0, 0, 0, 9, 0, 0, 6 },
                { 0, 0, 0, 7, 8, 6, 4, 2, 0 },
                { 8, 6, 0, 0, 0, 0, 0, 5, 9 } };

       if(solveSudoku(sudoku, 0, 0)){
        printSudoku(sudoku);
       }
       else{
        System.out.println("No Solution");
       }
        
    }
}
