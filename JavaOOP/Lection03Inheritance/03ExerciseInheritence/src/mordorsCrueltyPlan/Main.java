package mordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Gandalf gandalf = new Gandalf();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(br.readLine().split("\\s+")).forEach(gandalf::eatFood);
        System.out.println(gandalf.getFoodPoints());
        System.out.println(gandalf.getMood());

    }
}
