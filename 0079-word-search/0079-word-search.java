class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && isExist(board,i,j,word,0)){
                    return true;
                }
            }

        }
        return false;
    }
    public static boolean isExist(char[][] board,int i,int j,String word,int pos){
        if(pos==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        if(word.charAt(pos)!=board[i][j]){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='*';
        if(isExist(board,i+1,j,word,pos+1)||
        isExist(board,i-1,j,word,pos+1)||
        isExist(board,i,j+1,word,pos+1)||
        isExist(board,i,j-1,word,pos+1)){
            return true;
        }
        board[i][j]=temp;
        return false;
    }
}