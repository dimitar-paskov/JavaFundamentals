import java.text.DecimalFormat;
import java.util.Scanner;

public class EP08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        int [][] chamber = new int[15][15];

        int playerHitPoints = 18500;
        double HeiganHitPoints = 3000000;

        int playerRowPosition = 7;
        int playerColPosition = 7;

        int nextTurnDamage = 0;

        String command = "";

        while (true){

            int ntDamage = nextTurnDamage;
            HeiganHitPoints -= damageToHeigan;
            playerHitPoints -= ntDamage;
            if (playerHitPoints<=0){
                command = "Cloud";
                break;
            }
            if (HeiganHitPoints <=0){
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");
            command = tokens[0];
            int attackedRow = Integer.parseInt(tokens[1]);
            int attackedCol = Integer.parseInt(tokens[2]);

            int damage=0;


            switch (command){
                case "Cloud":{
                    damage = 3500;
                    nextTurnDamage = 3500;
                }break;
                case "Eruption":{
                    damage = 6000;
                    nextTurnDamage = 0;
                }break;
            }

            for (int i = attackedRow-1; i <= attackedRow+1 ; i++) {
                for (int j = attackedCol-1; j <= attackedCol+1 ; j++) {
                    try{
                        chamber[i][j] = 1;
                    }catch (Exception ex){

                    }
                }
            }


                if (attackedRow - 1 <= playerRowPosition
                        && playerRowPosition <= attackedRow + 1
                        && attackedCol - 1 <= playerColPosition
                        && playerColPosition <= attackedCol + 1) {
                    if (0 <= playerRowPosition - 1 && chamber[playerRowPosition - 1][playerColPosition] == 0 ) {
                        playerRowPosition = playerRowPosition - 1;
                        nextTurnDamage = 0;
                    } else if (playerColPosition + 1 < 15 && chamber[playerRowPosition][playerColPosition + 1] == 0 ) {
                        playerColPosition = playerColPosition + 1;
                        nextTurnDamage = 0;
                    } else if (playerRowPosition + 1 < 15 && chamber[playerRowPosition + 1][playerColPosition] == 0 ) {
                        playerRowPosition = playerRowPosition + 1;
                        nextTurnDamage = 0;
                    } else if (0 <= playerColPosition - 1 && chamber[playerRowPosition][playerColPosition - 1] == 0 ) {
                        playerColPosition = playerColPosition - 1;
                        nextTurnDamage = 0;
                    } else {
                        playerHitPoints -= damage;
                        if (playerHitPoints <= 0) {
                            break;
                        }

                    }
                }



            for (int i = attackedRow-1; i <= attackedRow+1 ; i++) {
                for (int j = attackedCol-1; j <= attackedCol+1 ; j++) {
                    try{
                        chamber[i][j] = 0;
                    }catch (Exception ex){

                    }
                }
            }

//            break;
        }

        DecimalFormat formatter = new DecimalFormat("#0.00");

        if (HeiganHitPoints<=0){
            System.out.println("Heigan: Defeated!");
        }else{
            System.out.println("Heigan: "+  formatter.format(HeiganHitPoints));
        }

        if (playerHitPoints<=0){
            System.out.println("Player: Killed by " + (command.equals("Cloud")?"Plague Cloud":"Eruption"));
        }else{
            System.out.printf("Player: %d\n", playerHitPoints);
        }

        System.out.printf("Final position: %d, %d\n", playerRowPosition, playerColPosition);



    }


}
