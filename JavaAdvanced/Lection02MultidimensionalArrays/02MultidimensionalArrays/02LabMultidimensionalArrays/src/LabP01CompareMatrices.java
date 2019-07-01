import java.util.Arrays;
import java.util.Scanner;

public class LabP01CompareMatrices {
    public static void main(String[] args) {

        int [][] firstMatrix= readMatrix();
        int [][] secondMatrix= readMatrix();

        compareMatrixes(firstMatrix, secondMatrix);
    }

    private static void compareMatrixes(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length){
            System.out.println("not equal");
            return;
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length){
                System.out.println("not equal");
                return;
            }

            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]){
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");

    }

    private static final Scanner scanner = new Scanner(System.in);

    private static int[][] readMatrix(){
        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int matrixRows = dimentions[0];
        int matrixCols = dimentions[1];
        int[][] matrix = new int[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
