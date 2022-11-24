@@ -0,0 +1,102 @@
class Solution {
	public static void main(String[] args) {
		char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

		System.out.println(exist(board, "ABCCED") ? "ABCCED was found" : "ABCCED was NOT found");
		System.out.println(exist(board, "ABCCEDF") ? "ABCCEDF was found" : "ABCCEDF was NOT found");
		System.out.println(exist(board, "ABCCEDS") ? "ABCCEDS was found" : "ABCCEDS was NOT found");
		System.out.println(exist(board, "ABCCEDA") ? "ABCCEDA was found" : "ABCCEDA was NOT found");
		System.out.println();
		char board2[][] =  {{'A','B','C','E'},{'S','F','C','S'}, {'A','D','E','E'}};
		System.out.println(exist(board2, "SEE") ? "SEE was found" : "SEE was NOT found");
		System.out.println(exist(board2, "SEEC") ? "SEEC was found" : "SEEC was NOT found");
		System.out.println(exist(board2, "DFCCBASFCSEE") ? "DFCCBASFCSEE was found" : "DFCCBASFCSEE was NOT found");
		System.out.println(exist(board2, "DFCCBASFCSEEA") ? "DFCCBASFCSEEA was found" : "DFCCBASFCSEEA was NOT found");

		System.out.println(exist(board2, "ABCB") ? "ABCB was found" : "ABCB was NOT found");
		
	}
    public static boolean exist(char[][] board, String word) {
        int pos[] = {0};
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (word.charAt(pos[0]) == board[i][j]){
					pos[0]++;
					boolean ans = solveRecur(board,word, pos, i, j);

					if(ans == true){
						return true;
					}
					pos[0] = 0;
				}
			}
		}
		return false;
    }
	private static boolean solveRecur(char[][] board, String word, int[] pos, int i, int j) {
		if (word.length() == pos[0]){
			return true;
		}
		boolean ans = false;
		int original = pos[0];
		//Try upwards first
		if (dimensions(i-1, j, board.length, board[0].length) == true){
			if (board[i-1][j] == word.charAt(pos[0])){
				pos[0]++;
				ans = solveRecur(board,word, pos, i - 1, j);
			}
		}
		if (ans == true){
			return true;
		}
		ans = false;
		pos[0] = original;
		//Try to the right
		if (dimensions(i, j+1, board.length, board[0].length) == true){
			if (board[i][j+1] == word.charAt(pos[0])){
				pos[0]++;
				ans = solveRecur(board,word, pos, i, j+1);
			}
		}

		if (ans == true){
			return true;
		}
		ans = false;
		pos[0] = original;

		//Try downwards
		if (dimensions(i+1, j, board.length, board[0].length) == true){
			if (board[i+1][j] == word.charAt(pos[0])){
				pos[0]++;
				ans = solveRecur(board,word, pos, i+1, j);
			}
		}

		if (ans == true){
			return true;
		}
		ans = false;
		pos[0] = original;

		//Try to the left
		if (dimensions(i, j-1, board.length, board[0].length) == true){
			if (board[i][j-1] == word.charAt(pos[0])){
				pos[0]++;
				ans = solveRecur(board,word, pos, i, j-1);
			}
		}
		if (ans == true){
			return true;
		}
		pos[0] = original;

		return false;
	}
	private static boolean dimensions(int i, int j, int iLength, int jLength) {
		if (i < 0 || j < 0 || i >= iLength || j >= jLength) 
		return false;

		return true;
	}
}