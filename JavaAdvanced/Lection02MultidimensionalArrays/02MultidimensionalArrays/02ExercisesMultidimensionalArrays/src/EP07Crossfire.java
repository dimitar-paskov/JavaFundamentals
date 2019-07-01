import java.util.Arrays;
import java.util.Scanner;

public class EP07Crossfire {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int rows = dimensions[0];
            int cols = dimensions[1];

            int[][] matrix = new int[rows][cols];

            // fill the matrix
            int count = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = count++;
                }
            }

            String line;

            while (!"Nuke it from orbit".equals(line = scanner.nextLine())) {
            System.out.println(line);
                int[] commands = Arrays.stream(line.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int row = commands[0];
                int col = commands[1];
                int radius = commands[2];

//            System.out.println(row);
//            System.out.println(col);
//            System.out.println(radius);

                matrix = crossFire(matrix, row, col, radius);
            printMatrix(matrix);

            }

            printMatrix(matrix);

    }

    private static int[][] crossFire(int[][] matrix, int hitRow, int hitCol, int hitWave) {

        // Mark destroyed part of the column
        for (int row = hitRow - hitWave; row <= hitRow + hitWave; row++)
        {
            if (isInMatrix(row, hitCol, matrix))
            {
                matrix[row][hitCol] = -1;
            }
        }

        // Mark destroyed part of the row
        for (int col = hitCol - hitWave; col <= hitCol + hitWave; col++)
        {
            if (isInMatrix(hitRow, col, matrix))
            {
                matrix[hitRow][col] = -1;
            }
        }

        // Remove destroyed cells
        for (int i = 0; i < matrix.length; i++)
        {
            // Remove destroyed cells if there is ones
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] < 0)
                {
                    matrix[i] = Arrays.stream(matrix[i]).filter(n -> n > 0).toArray();
                    break;
                }
            }

            // Remove empty rows
            if (matrix[i].length < 1)
            {
                int[][] temp = new int[matrix.length-1][];
                int k=0;
                for (int j = 0; j < matrix.length; j++) {
                    if (j!=i){
                        temp[k++] = matrix[j];
                    }
                }

                matrix = temp;
                i--;
            }
        }


        return matrix;

    }



    private static boolean isInMatrix( int row, int col, int[][] matrix ){
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length;
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
