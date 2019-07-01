import java.util.Arrays;
import java.util.Scanner;

public class EP05MatrixShuffling {
    public static void main(String[] args) {

        String[][] matrix = readMatrix();


        String line;

        while (!"END".equals(line = scanner.nextLine())) {

            String[] tokens = line.split("\\s+");

            if (!"swap".equals(tokens[0])) {
                System.out.println("Invalid input!");
                continue;
            }

            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            try{
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;

                printMatrix(matrix);





            }catch (Exception ex){

                System.out.println("Invalid input!");
            }


        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    private static String[][] readMatrix() {
        int[] dimentions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int matrixRows = dimentions[0];
        int matrixCols = dimentions[1];
        String[][] matrix = new String[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            String[] arr = scanner.nextLine().split(" ");
            matrix[i] = arr;
        }
        return matrix;
    }


    private static void printMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
