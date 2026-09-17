class Solution {
    int ans = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char ch[] : board){
            Arrays.fill(ch,'.');
        }
        backtrack(0,n,board);
        return ans;
    }
    private void backtrack(int row, int n,char [][] board){
        if(row == n){
            ans++;
            return;
        }
        for(int col=0;col<n;col++){
            if(check(board,row,col)){
                board[row][col] = 'Q';
                backtrack(row+1,n,board);
                board[row][col] = '.';
            }
        }
    }
    private boolean check(char board[][], int row, int col){
        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q') return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}