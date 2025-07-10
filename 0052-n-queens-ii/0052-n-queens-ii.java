public class Solution {
    public static int nQueen(char[][] board, int row) {
        if (row == board.length) {
            return 1; // return 1 to count the valid solution
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                count += nQueen(board, row + 1);
                board[row][i] = '.';
            }
        }
        return count;
    }
    
    public static boolean isSafe(char[][] board, int row, int col) {
        // up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        return nQueen(board, 0);
    }
}
