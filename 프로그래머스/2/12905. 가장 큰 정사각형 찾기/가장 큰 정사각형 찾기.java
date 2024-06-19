import java.lang.Math;

class Solution
{
    public int solution(int [][] board)
    {
        int [][] ones = new int [board.length][board[0].length];
        int maxStreak = 0;
        
        if(board.length==1){
            return board[0][0];
        }
        
        // 행 초기세팅
        for(int i=0; i<board.length; i++){
            ones[i][0] = board[i][0];//으아악 으아악 for문 하나로 어떻게 합쵸ㅕ
        }
        
        //열 초기세팅
        for(int j=0; j<board[0].length; j++){
            ones[0][j] = board[0][j];
        }
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    ones[i][j] = Math.min(Math.min(ones[i-1][j], ones[i][j-1]), ones[i-1][j-1]) + 1;
                    maxStreak = Math.max(maxStreak, ones[i][j]);
                }
            }
        }
        
        return maxStreak*maxStreak;
    }
}