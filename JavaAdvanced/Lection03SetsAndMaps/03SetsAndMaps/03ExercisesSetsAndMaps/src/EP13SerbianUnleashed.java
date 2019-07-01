import java.util.LinkedHashMap;
import java.util.Scanner;

public class EP13SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String,Integer>> concerts = new LinkedHashMap<>();

        String line = "";

        while (!"End".equals(line = scanner.nextLine())){
            String[] split = line.split(" @");
            if (split.length < 2){
                continue;
            }

            String singer = split[0];
            String[] split2 = split[1].split(" ");
            if (split2.length < 3){
                continue;
            }

            int ticketPrice = 0;
            int ticketCount = 0;
            try {
                ticketCount = Integer.parseInt(split2[split2.length-1]);
                ticketPrice = Integer.parseInt(split2[split2.length-2]);

            }catch (Exception ex){
                continue;
            }

            String venue = "";
            for (int i = 0; i < split2.length - 2; i++) {
                venue = venue + split2[i] + " ";
            }

            venue = venue.substring(0,venue.length()-1);

            concerts.putIfAbsent(venue, new LinkedHashMap<>());
            concerts.get(venue).putIfAbsent(singer, 0);
            concerts.get(venue).put(singer, concerts.get(venue).get(singer) + ticketCount*ticketPrice);


        }

        concerts.entrySet()
                .stream()
                .forEach(v->{
                    System.out.println(v.getKey());
                    v.getValue()
                            .entrySet()
                            .stream()
                            .sorted((s1,s2)->Integer.compare(s2.getValue(),s1.getValue()))
                            .forEach(s->{
                                System.out.printf("#  %s -> %d\n", s.getKey(), s.getValue());
                            });
                });
    }
}
