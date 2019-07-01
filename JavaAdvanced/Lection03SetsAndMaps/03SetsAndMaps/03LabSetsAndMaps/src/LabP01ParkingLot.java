import java.util.HashSet;
import java.util.Scanner;

public class LabP01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> parkingLot = new HashSet<>();
        String line = "";

        while (!"END".equals(line = scanner.nextLine())){
            String[] parts = line.split(", ");


            if (parts[0].equals("IN")){
                parkingLot.add(parts[1]);
            }else {
                parkingLot.remove(parts[1]);
            }
        }

        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String car:parkingLot
                 ) {
                System.out.println(car);
            }
        }

    }
}
