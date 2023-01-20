import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(board));

        char[][] board2 = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(board2));
        char[][] board3 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '1', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(board3));

        char[][] board4 = {
                { '8', '7', '5', '9', '2', '1', '3', '4', '6' }, { '3', '6', '1', '7', '5', '4', '8', '9', '2' },
                { '2', '4', '9', '8', '6', '3', '7', '1', '5' }, { '5', '8', '4', '6', '9', '7', '1', '2', '3' },
                { '7', '1', '3', '2', '4', '8', '6', '5', '9' }, { '9', '2', '6', '1', '3', '5', '4', '8', '7' },
                { '6', '9', '7', '4', '1', '2', '5', '3', '8' }, { '1', '5', '8', '3', '7', '9', '2', '6', '4' },
                { '4', '3', '2', '5', '8', '6', '9', '7', '1' }
        };
        System.out.println(isValidSudoku(board4));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<Integer, HashSet<Character>>();
        HashMap<String, HashSet<Character>> square = new HashMap<String, HashSet<Character>>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String pair = (int) Math.floor(i / 3) + "," + (int) Math.floor(j / 3);
                square.put(pair, new HashSet<>());
            }
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    String pair = (int) Math.floor(i / 3) + "," + (int) Math.floor(j / 3);
                    if (rows.get(i).contains(board[i][j]) || cols.get(j).contains(board[i][j])
                            || square.get(pair).contains(board[i][j])) {
                        return false;
                    }
                    square.get(pair).add(board[i][j]);
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);
                }
            }
        }
        

        return true;
    }
}