class Solution {
    static int count;
    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }
        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }
        return true;
    }
    static void queens(boolean[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            count++;
            return ;
        }
        
        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe
            if(isSafe(board, row, col)) {
                board[row][col] = true;
                queens(board, row + 1,ans);
                board[row][col] = false;
            }
        }
        return ;
    }
    public int totalNQueens(int n) {
        List<List<String>> ans= new ArrayList();
        boolean[][] board= new boolean[n][n];
        count=0;
        queens(board,0,ans);
        return count;
    }
}