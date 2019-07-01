import java.util.Scanner;

public class EP07RecursiveFibonacci {
    private static final int MAX = 50;
    private static long[] fibunacciMember = new long[MAX];
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fib(n));


    }

    private static long fib(int n){
        if (0 == fibunacciMember[n]){
            if (n < 2){
                fibunacciMember[n] = 1;
            }else {
                fibunacciMember[n] = fib(n-1) + fib(n-2);
            }
        }
        return fibunacciMember[n];
    }
}
