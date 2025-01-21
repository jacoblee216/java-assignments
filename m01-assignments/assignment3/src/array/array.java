package array;
import java.util.Scanner;

public class array {
    public static boolean equals(int[][] m1, int [][] m2) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int[][] matrix1;
        int[][] matrix2;
        matrix1 = new int[3][3];
        matrix2 = new int[3][3];
        System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                matrix1[i][j] = input.nextInt();
            }
        }
        System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                matrix2[i][j] = input.nextInt();
            }
        }
        if (equals(matrix1, matrix2)) {
            System.out.print("The two arrays are identical");
        }
        else {
            System.out.print("The two arrays are not identical");
        }

        input.close();
    }

}
