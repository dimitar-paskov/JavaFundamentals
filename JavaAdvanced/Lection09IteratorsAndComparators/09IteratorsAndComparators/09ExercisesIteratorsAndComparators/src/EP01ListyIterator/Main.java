package EP01ListyIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        ListyIterator iterator = new ListyIterator(list);

        String line = "";
        while (!"END".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Create":{
                    for (int i = 1; i < tokens.length; i++) {
                        list.add(tokens[i]);
                    }

                }break;
                case "Move":{
                    System.out.println(iterator.move());
                }break;
                case  "Print":{
                    iterator.print();
                }break;
                case "HasNext":{
                    System.out.println(iterator.hasNext());
                }break;
            }
        }


    }
}
