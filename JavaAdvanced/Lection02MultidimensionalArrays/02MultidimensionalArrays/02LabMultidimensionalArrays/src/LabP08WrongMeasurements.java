import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LabP08WrongMeasurements {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int [][] matrix = readMatrix();
        int[] valueIndexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rowIndex = valueIndexes[0];
        int colIndex = valueIndexes[1];

        int wrongValue = matrix[rowIndex][colIndex];

        int [][] answerMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int [] arr = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]!=wrongValue){
                    arr[j] = matrix[i][j];
                }else{
                    if (i-1 >= 0 && matrix[i-1][j]!=wrongValue){
                        arr[j] += matrix[i-1][j];
                    }

                    if (j+1 < matrix[i].length && matrix[i][j+1]!=wrongValue){
                        arr[j] += matrix[i][j+1];
                    }

                    if (i+1 < matrix.length && matrix[i+1][j]!=wrongValue){
                        arr[j] += matrix[i+1][j];
                    }
                    if (j-1 >=0 && matrix[i][j-1]!=wrongValue){
                        arr[j] += matrix[i][j-1];
                    }

//                    arr[j] = matrix[i-1][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i][j-1];
                }
            }

            answerMatrix[i] = arr;
        }

        for (int i = 0; i < answerMatrix.length; i++) {

            System.out.println(Arrays.stream(answerMatrix[i])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }

    private static int[][] readMatrix(){
        int dimention = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimention][];
        for (int i = 0; i < dimention; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
