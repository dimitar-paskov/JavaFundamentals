package EP09CustomListIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomArrayLis<String> list = new CustomArrayLis<>();

        String line = "";
        while (!"END".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Add":{
                    String element = tokens[1];
                    list.add(element);

                }break;
                case "Remove": {
                    int index = Integer.parseInt(tokens[1]);
                    list.remove(index);
                }break;
                case "Contains":{
                    String element = tokens[1];
                    System.out.println(list.contains(element));
                }break;
                case "Swap":{
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    list.swap(index1, index2);
                }break;
                case "Greater":{
                    String elem = tokens[1];
                    System.out.println(list.countGreaterThan(elem));
                }break;
                case "Max":{
                    System.out.println(list.getMax());
                }break;
                case "Min":{
                    System.out.println(list.getMin());
                }break;
                case "Print":{
//                    for (int i = 0; i < list.getCount(); i++) {
//                        System.out.println(list.get(i));
//                    }
                    for (String item :
                            list) {
                        System.out.println(item);
                    }
                }break;
                case "Sort":{
                    Sorter.sort(list);
                }break;
            }
        }
    }
}
