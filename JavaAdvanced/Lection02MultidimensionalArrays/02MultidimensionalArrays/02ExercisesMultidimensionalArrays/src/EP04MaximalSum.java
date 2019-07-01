import java.util.Arrays;
import java.util.Scanner;

public class EP04MaximalSum {
    public static void main(String[] args) {
        int [][] matrix = readMatrix();

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < matrix.length-2; i++) {

            for (int j = 0; j < matrix[i].length-2; j++) {
                int sum = 0;
                sum += matrix[i][j] + matrix[i][j+1] + matrix[i][j+2]
                        + matrix[i+1][j]  + matrix[i+1][j+1] + matrix[i+1][j+2]
                        + matrix[i+2][j]  + matrix[i+2][j+1] + matrix[i+2][j+2];
                if (sum > maxSum){
                    maxSum = sum;
                    maxRow = i;
                    maxCol = j;

                }
            }

        }

        System.out.println("Sum = " + maxSum);
        System.out.println(matrix[maxRow][maxCol] + " " + matrix[maxRow][maxCol+1] + " " + matrix[maxRow][maxCol+2]);
        System.out.println(matrix[maxRow + 1][maxCol] + " " + matrix[maxRow + 1][maxCol+1] + " " + matrix[maxRow + 1][maxCol+2]);
        System.out.println(matrix[maxRow + 2][maxCol] + " " + matrix[maxRow + 2][maxCol+1] + " " + matrix[maxRow + 2][maxCol+2]);



    }

    private static final Scanner scanner = new Scanner(System.in);

    private static int[][] readMatrix(){
        int[] dimentions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int matrixRows = dimentions[0];
        int matrixCols = dimentions[1];
        int[][] matrix = new int[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
