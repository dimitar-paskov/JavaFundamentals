import java.util.Scanner;

public class EP01FillMatrix {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] tokens = scanner.nextLine().split(", ");
        int dimension = Integer.parseInt(tokens[0]);
        String variant = tokens[1];

        int [][] matrix;

        switch (variant){
            case "A":{
                matrix = readMatrixA(dimension);
                printMatrix(matrix, dimension);
            }break;
            case "B":{
                matrix = readMatrixB(dimension);
                printMatrix(matrix, dimension);
            }break;

        }



    }

    private static int[][] readMatrixA(int dimiension) {
        int [][] matrix = new int[dimiension][dimiension];
        int count = 1;
        for (int i = 0; i < dimiension; i++) {
            for (int j = 0; j < dimiension; j++) {
            matrix[j][i] = count++;
            }

        }

        return matrix;

    }

    private static int[][] readMatrixB(int dimension) {
        int [][] matrix = new int[dimension][dimension];
        int count = 1;
        for (int i = 0; i < dimension; i++) {
            if (i % 2 == 0){
                for (int j = 0; j < dimension; j++) {
                    matrix[j][i] = count++;
                }
            }else{
                for (int j = dimension-1; j >= 0; j--) {
                    matrix[j][i] = count++;
                }
            }


        }

        return matrix;

    }

    private static void printMatrix(int[][] matrix, int dimension){
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
