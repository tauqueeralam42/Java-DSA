public class NQueen {
    static int count =0;

    public static boolean isSafe(char board[][], int row, int col){
        //verical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q')
                return false;
        }
        //digonal left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q')
                return false;
        }
        //digonal right up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q')
                return false;
        }
        return true;
    }

    public static void nQueen(char board[][], int row) {
        // base case
        if(row==board.length){
            count++;
            printBoard(board);
            return;
        }
        // column loop
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueen(board, row + 1);
                board[row][j] = 'x';
            }
            
        }

    }

    public static void printBoard(char board[][]) {
        
        System.out.println("----Chess Board----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        
        
    }

    public static void main(String[] args) {
        int n = 10  ;
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                board[i][j] = 'x';
        }

        nQueen(board, 0);
        System.out.println("Total no. of  Ways = "+count);

    }
}
