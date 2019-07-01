import java.util.*;

public class EP08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = "";
        LinkedHashMap<String, HashSet<String>> result = new LinkedHashMap<>();

        while (!"JOKER".equals(line = scanner.nextLine())){
            String[] parts = line.split(": ");
            String name = parts[0];
            List<String> cards = Arrays.asList(parts[1].split(", "));

            result.putIfAbsent(name, new HashSet<String>());
            result.get(name).addAll(cards);

        }

        for (String name :
                result.keySet()) {
            int sum = 0;
            for (String card :
                    result.get(name)) {
                sum += getCardValue(card);


            }

            System.out.printf("%s: %d\n", name, sum);
        }
    }

    private static int getCardValue(String card) {
        int power = getPowerInt(card);
        int type = getTypeInt(card);
        return power * type;
    }

    private static int getTypeInt(String card) {
        Character typeOfCard = card.charAt(card.length()-1);
        switch (typeOfCard){
            case 'C':return 1;
            case 'D':return 2;
            case 'H':return 3;
            case 'S':return 4;
            default:return 0;
        }

    }

    private static int getPowerInt(String card) {
        if (card.length() > 2){
            return 10;
        }else {
            Character powerOfCard = card.charAt(0);
            switch (powerOfCard){
                case '2': return 2;
                case '3': return 3;
                case '4': return 4;
                case '5': return 5;
                case '6': return 6;
                case '7': return 7;
                case '8': return 8;
                case '9': return 9;
                case 'J': return 11;
                case 'Q': return 12;
                case 'K': return 13;
                case 'A': return 14;
                default: return 0;
            }
        }

    }
}
