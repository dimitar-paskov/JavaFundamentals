import java.util.Arrays;
import java.util.Scanner;

public class EP03DiagonalDifference {
    public static void main(String[] args) {
        int [][] matrix = readMatrix();
        int primeDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            primeDiagonal += matrix[i][i];
            secondaryDiagonal += matrix[matrix.length-1-i][i];
        }

        System.out.println(Math.abs(primeDiagonal-secondaryDiagonal));

    }

    private static final Scanner scanner = new Scanner(System.in);

    private static int[][] readMatrix(){
        int dimension = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimension][];
        for (int i = 0; i < dimension; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
