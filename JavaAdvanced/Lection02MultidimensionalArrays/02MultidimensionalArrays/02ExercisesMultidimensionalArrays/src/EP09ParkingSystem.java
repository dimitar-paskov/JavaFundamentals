import java.util.Arrays;
import java.util.Scanner;

public class EP09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimentions[0];
        int cols = dimentions[1];

        int[][] parking = new int[rows][cols];

        String line;

        while ("stop".equals(line = scanner.nextLine())){
            int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int entryRow = tokens[0];
            int parkRow = tokens[1];
            int parkCol = tokens[2];

            int distanceToTheLot = Math.abs(entryRow - parkRow);

            int desiredLot = parking[parkRow][parkCol];

            int count = 1;
//            while (isInBoundary(parkCol) && desiredLot!=0 ){
//                desiredLot = parking[parkRow][--parkCol];
//            }

        }
    }
}
