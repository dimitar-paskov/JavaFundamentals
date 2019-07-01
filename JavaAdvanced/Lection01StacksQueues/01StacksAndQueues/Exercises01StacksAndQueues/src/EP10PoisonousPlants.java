import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class EP10PoisonousPlants {
    public static void main(String[] args) throws IOException {

        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(buffer.readLine());


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> helperStack = new ArrayDeque<>();

        String[] numberStr = buffer.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(numberStr[i]));
        }

        int answer = 0;

        int diedPlants = 1;

        while (diedPlants > 0) {
            diedPlants = 0;
            int current = stack.pop();
            boolean last = false;
            while (stack.size() > 0) {
                int beforeCurrent = stack.pop();
                if (current <= beforeCurrent) {
                    helperStack.push(current);
                    current = beforeCurrent;
                } else {
                    diedPlants++;
                    current = beforeCurrent;
                }
            }
            helperStack.push(current);

            if (diedPlants > 0) {
                answer++;
            } else {
                break;
            }

            diedPlants = 0;

            current = helperStack.pop();
            stack.push(current);
            while (helperStack.size() > 0) {
//                int current = helperStack.pop();
                int beforeCurrent = helperStack.pop();

                if (current >= beforeCurrent) {
                    stack.push(beforeCurrent);
                    current = beforeCurrent;
                }else{
                    diedPlants++;
                    current = beforeCurrent;
                }
            }



            if (diedPlants > 0) {
                answer++;
            } else {
                break;
            }


        }

        System.out.println(answer);


    }
}
