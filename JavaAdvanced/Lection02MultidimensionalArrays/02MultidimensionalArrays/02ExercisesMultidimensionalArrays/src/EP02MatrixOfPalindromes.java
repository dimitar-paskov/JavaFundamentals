import java.util.Arrays;
import java.util.Scanner;

public class EP02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimentions[0];
        int cols = dimentions[1];

        String [][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int a = 'a';
                char endSymbol = (char)(a+i);
                char middleSymbol = (char)(a+i+j);
                StringBuilder sb = new StringBuilder();
                sb.append(endSymbol);
                sb.append(middleSymbol);
                sb.append(endSymbol);
                String str = sb.toString();

                matrix[i][j] = str;
            }
        }

            printMatrix(matrix);

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
