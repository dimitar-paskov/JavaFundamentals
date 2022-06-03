package testexam;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExcelFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] header = scanner.nextLine().split(",\\s+");

        String[][] matrix = new String[n-1][];

        for (int i = 0; i < n - 1; i++) {
            String[] tokens = scanner.nextLine().split(",\\s+");
            matrix[i] = tokens;

        }

        String[] tokens = scanner.nextLine().split("\\s+");
        String command = tokens[0];


        switch (command){
            case "hide":{
                String param = tokens[1];
                int col = Arrays.asList(header).indexOf(param);
                System.out.println(String.join(" | ",
                        IntStream.range(0, header.length)
                                .filter(i -> i != col)
                                .boxed()
                                .map(i -> header[i])
                                .toArray(size-> new String[size])));
                for (String[] arr :
                        matrix) {
                    System.out.println(String.join(" | ",
                            IntStream.range(0, arr.length)
                                    .filter(i -> i != col)
                                    .boxed()
                                    .map(i -> arr[i])
                                    .toArray(size-> new String[size])));
                }
            }break;
            case "sort":{
                String column = tokens[1];
                int col = Arrays.asList(header).indexOf(column);

                System.out.println(String.join(" | ", header));

                for (String[] arr :
                        Arrays.stream(matrix).sorted((a1,a2)->a1[col].compareTo(a2[col])).toArray(size -> new String[size][])) {

                        System.out.println(String.join(" | ", arr));

                }

            }break;
            case "filter":{
                String column = tokens[1];
                String param = tokens[2];
                int col = Arrays.asList(header).indexOf(column);

                System.out.println(String.join(" | ", header));

                for (String[] arr :
                        matrix) {
                    if (arr[col].equals(param)){
                        System.out.println(String.join(" | ", arr));
                    }
                }




            }
        }
    }
}
