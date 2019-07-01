import java.util.Arrays;
import java.util.Scanner;

public class LabP04SumMatrixElements {
    public static void main(String[] args) {
        int [][] matrix = readMatrix();
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println(sum);

    }

    private static final Scanner scanner = new Scanner(System.in);

    private static int[][] readMatrix(){
        int[] dimentions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int matrixRows = dimentions[0];
        int matrixCols = dimentions[1];
        System.out.println(matrixRows);
        System.out.println(matrixCols);
        int[][] matrix = new int[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
