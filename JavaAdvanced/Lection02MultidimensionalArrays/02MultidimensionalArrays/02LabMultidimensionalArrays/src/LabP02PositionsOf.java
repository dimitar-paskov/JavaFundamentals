import java.util.Arrays;
import java.util.Scanner;

public class LabP02PositionsOf {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int [][] matrix = readMatrix();
        int number = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number){
                    found = true;
                    System.out.println(i + " " + j);
                }
            }
        }

        if (!found){
            System.out.println("not found");
        }


    }


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
