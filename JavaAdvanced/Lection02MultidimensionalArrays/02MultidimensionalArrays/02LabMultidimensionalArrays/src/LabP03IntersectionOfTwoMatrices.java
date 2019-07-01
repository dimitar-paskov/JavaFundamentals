import java.util.Arrays;
import java.util.Scanner;

public class LabP03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[M][N];
        for (int i = 0; i < M; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = arr[j].charAt(0);
            }
        }

        for (int i = 0; i < M; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == arr[j].charAt(0)){
                    System.out.print(matrix[i][j] + " ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }


    }
}
