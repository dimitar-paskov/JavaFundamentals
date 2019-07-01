import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EP06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int angle = Integer.parseInt(line.substring(7,line.length()-1));

        List<String> words = new ArrayList<String>();
        int maxLength = Integer.MIN_VALUE;
        while (!"END".equals(line = scanner.nextLine())){
            if (line.length() > maxLength){
                maxLength = line.length();
            }
            words.add(line);
        }

        int rows = words.size();

        char[][] matrix = new char[rows][maxLength];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < maxLength; j++) {
                try{
                    matrix[i][j] = words.get(i).charAt(j);

                }catch (Exception ex){
                    matrix[i][j] = ' ';
                }

            }
        }

        matrix = rotate(matrix, angle);

        printMatrix(matrix);



    }

    private static char[][] rotate(char[][] matrix, int angle) {
        angle = angle % 360;

        if (angle == 90){
            char[][] rotated90 = new char[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    rotated90[j][i] = matrix[matrix.length-1 - i][j];
                }
            }

            return rotated90;

        }

        if (angle == 180){
            char[][] rotated180 = new char[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    rotated180[i][j] = matrix[matrix.length-1 - i][matrix[0].length -1 -j];
                }
            }

            return rotated180;

        }



        if (angle == 270){
            char[][] rotated270 = new char[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    rotated270[j][i] = matrix[i][matrix[0].length-1 - j];
                }
            }

            return rotated270;

        }

        return matrix;


    }

    private static void printMatrix(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j==matrix[i].length-1){
                    System.out.print(matrix[i][j]);
                }else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }


}
