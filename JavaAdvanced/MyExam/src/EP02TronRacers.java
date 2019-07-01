import java.util.Scanner;

public class EP02TronRacers {
    static int firstX = 0;
    static int firstY = 0;
    static int secondX = 0;
    static int secondY = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        String[][] matrix = new String[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("f")){
                    firstX = i;
                    firstY = j;
                }

                if (matrix[i][j].equals("s")){
                    secondX = i;
                    secondY = j;
                }
            }

        }


        boolean isdeadF = false;
        boolean isdeadS = false;

        while ((!isdeadF) && (!isdeadS)){
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstCommand = tokens[0];
            String secondCommand = tokens[1];

            isdeadF = move(matrix, firstCommand, "f");
            if (isdeadF){
                printMatrix(matrix);
                break;
            }
            isdeadS = move(matrix,secondCommand, "s");
            if (isdeadS){
                printMatrix(matrix);
                break;
            }


        }

    }

    private static boolean move(String[][] matrix, String command, String l) {
        boolean isDead = false;

        int x = 0;
        int y = 0;

        switch (l){
            case "f":{
                x = firstX;
                y = firstY;

            }break;
            case "s":{
                x = secondX;
                y = secondY;
            }break;

        }


        switch (command){
            case "down":{
                x = x+1;
                if (x > matrix.length-1){
                    x = 0;
                }

            }break;
            case "up":{
                x=x-1;
                if (x<0){
                    x=matrix.length-1;
                }

            }break;
            case "right":{
                y=y+1;
                if (y>matrix.length-1){
                    y=0;
                }

            }break;
            case "left":{
                y=y-1;
                if (y<0){
                    y = matrix.length-1;
                }

            }break;

        }

        switch (l){
            case "f":{
                if (matrix[x][y].equals("*")){
                    matrix[x][y] = "f";
                    firstX = x;
                    firstY = y;
                }else if (matrix[x][y].equals("s")){
                    isDead = true;
                    matrix[x][y]="x";
                }

            }break;
            case "s":{
                if (matrix[x][y].equals("*")){
                    matrix[x][y] = "s";
                    secondX = x;
                    secondY = y;
                }else if (matrix[x][y].equals("f")){
                    isDead = true;
                    matrix[x][y]="x";
                }

            }break;

        }

//        printMatrix(matrix);
//        System.out.println();
        return isDead;



    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
