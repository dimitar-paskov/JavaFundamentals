import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class LabP02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> invitations = new TreeSet<>();
        String line = "";

        while (!"PARTY".equals(line = scanner.nextLine())){
           invitations.add(line);
        }

        while (!"END".equals(line = scanner.nextLine())){
            invitations.remove(line);
        }

        System.out.println(invitations.size());
        for (String invitation:invitations
             ) {
            System.out.println(invitation);
        }

    }
}
