import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

		System.out.println(exist(board, "ABCCED") ? "ABCCED was found" : "ABCCED was NOT found");
		System.out.println(exist(board, "ABCCEDF") ? "ABCCEDF was found" : "ABCCEDF was NOT found");
		System.out.println(exist(board, "ABCCEDS") ? "ABCCEDS was found" : "ABCCEDS was NOT found");
		System.out.println(exist(board, "ABCCEDA") ? "ABCCEDA was found" : "ABCCEDA was NOT found");
		System.out.println();
		System.out.println("Board 2");
		char board2[][] =  {{'A','B','C','E'},{'S','F','C','S'}, {'A','D','E','E'}};
		System.out.println(exist(board2, "SEE") ? "SEE was found" : "SEE was NOT found");
		System.out.println(exist(board2, "SEEC") ? "SEEC was found" : "SEEC was NOT found");
		System.out.println(exist(board2, "DFCCBASFCSEE") ? "DFCCBASFCSEE was found" : "DFCCBASFCSEE was NOT found");
		System.out.println(exist(board2, "DFCCBASFCSEEA") ? "DFCCBASFCSEEA was found" : "DFCCBASFCSEEA was NOT found");

		System.out.println(exist(board2, "ABCB") ? "ABCB was found" : "ABCB was NOT found");
		System.out.println(exist(board2, "CEECCESC") ? "CEECCESC was found" : "CEECCESC was NOT found");
		System.out.println(exist(board2, "A") ? "A was found" : "A was NOT found");
		System.out.println(exist(board2, "Z") ? "Z was found" : "Z was NOT found");
	}
    public static boolean exist(char[][] board, String word) {
        int pos[] = {0};
		boolean checked[][] = new boolean[board.length][board[0].length];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (word.charAt(pos[0]) == board[i][j]){
					pos[0]++;
					checked[i][j] = true;
					boolean ans = solveRecur(board,word, pos, i, j, checked);

					if(ans == true){
						return true;
					}
					pos[0] = 0;
					checked[i][j] = false;
				}
			}
		}
		return false;
    }
	private static boolean solveRecur(char[][] board, String word, int[] pos, int i, int j, boolean[][] checked) {
		if (word.length() == pos[0]){
			return true;
		}
		boolean ans = false;
		int original = pos[0];
		boolean copy[][] = Arrays.stream(checked).map(boolean[]::clone).toArray(boolean[][]::new);
		//Try upwards first
		if (dimensions(i-1, j, board.length, board[0].length) == true && checked[i-1][j] == false){
			if (board[i-1][j] == word.charAt(pos[0])){
				pos[0]++;
				checked[i-1][j] = true;
				ans = solveRecur(board,word, pos, i - 1, j, checked);
			}
		}
		if (ans == true){
			return true;
		}
		ans = false;
		checked = copy;
		pos[0] = original;
		//Try to the right
		if (dimensions(i, j+1, board.length, board[0].length) == true && checked[i][j+1] == false){
			if (board[i][j+1] == word.charAt(pos[0])){
				pos[0]++;
				checked[i][j+1] = true;
				ans = solveRecur(board,word, pos, i, j+1, checked);
			}
		}

		if (ans == true){
			return true;
		}
		ans = false;
		checked = copy;
		pos[0] = original;

		//Try downwards
		if (dimensions(i+1, j, board.length, board[0].length) == true && checked[i+1][j] == false){
			if (board[i+1][j] == word.charAt(pos[0])){
				pos[0]++;
				checked[i+1][j] = true;
				ans = solveRecur(board,word, pos, i+1, j, checked);
			}
		}

		if (ans == true){
			return true;
		}
		ans = false;
		checked = copy;
		pos[0] = original;

		//Try to the left
		if (dimensions(i, j-1, board.length, board[0].length) == true && checked[i][j-1] == false){
			if (board[i][j-1] == word.charAt(pos[0])){
				pos[0]++;
				checked[i][j-1] = true;
				ans = solveRecur(board,word, pos, i, j-1, checked);
			}
		}
		if (ans == true){
			return true;
		}
		checked = copy;
		pos[0] = original;

		return false;
	}
	private static boolean dimensions(int i, int j, int iLength, int jLength) {
		if (i < 0 || j < 0 || i >= iLength || j >= jLength) 
		return false;

		return true;
	}
}