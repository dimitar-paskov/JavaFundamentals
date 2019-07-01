import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LabP03VoinaNumberGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>();
        firstPlayer.addAll(firstPlayerInput);

        List<Integer> secondPlayerInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>();
        secondPlayer.addAll(secondPlayerInput);

        for (int i = 0; i < 50; i++) {
//            System.out.println(i);
            int firstCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstCard);

            int secondCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard){
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            }else if (firstCard < secondCard){
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }else{
                firstPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }

            if (firstPlayer.size() == 0){
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayer.size() == 0){
                System.out.println("First player win!");
                return;
            }
        }

        if (firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        }else if (secondPlayer.size() > firstPlayer.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw");
        }





    }
}
