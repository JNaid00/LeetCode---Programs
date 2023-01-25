import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int matrix[][] = {
                { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 }
        };
        setZeroes(matrix);
        print(matrix);
        int matrix2[][] = {
                { 1, 1, 1 }, { 1, 0, 1}, { 1, 1, 1 }
        };
        setZeroes(matrix2);
        print(matrix2);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        Boolean rowZero = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i > 0) {
                        matrix[i][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (rowZero) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}