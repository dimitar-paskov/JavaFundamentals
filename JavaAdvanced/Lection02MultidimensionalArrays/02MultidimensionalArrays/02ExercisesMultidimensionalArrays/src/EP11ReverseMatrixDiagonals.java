import java.util.Arrays;
import java.util.Scanner;

public class EP11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

//        printMatrix(matrix);

        for (int i = rows + cols - 2, l = cols-1; i >= 0 ; i--, l--) {
            if (i >= rows-1) {
                for (int j = l, k = i - l; 0 <= j && j <= cols - 1 && 0 <= k && k <= rows - 1; j++, k--) {
                    System.out.print(matrix[k][j] + " ");
                }
                System.out.println();
            }else {
                l++;
                for (int j = l, k = i - l; 0 <= j && j <= cols - 1 && 0 <= k && k <= rows - 1; j++, k--) {
                    System.out.print(matrix[k][j] + " ");
                }
                System.out.println();
            }


        }

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
