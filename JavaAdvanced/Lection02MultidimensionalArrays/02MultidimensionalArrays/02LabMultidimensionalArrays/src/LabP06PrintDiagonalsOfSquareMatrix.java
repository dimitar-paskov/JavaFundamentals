import java.util.Arrays;
import java.util.Scanner;

public class LabP06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {

        int[][] matrix = readMatrix();

        for (int i = 0; i < matrix.length ; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length ; i++) {
            System.out.print(matrix[matrix.length-1-i][i] + " ");
        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    private static int[][] readMatrix(){
        int dimention = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimention][dimention];
        for (int i = 0; i < dimention; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
