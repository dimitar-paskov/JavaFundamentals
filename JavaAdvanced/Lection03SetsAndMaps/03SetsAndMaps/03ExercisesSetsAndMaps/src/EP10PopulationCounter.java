
import java.util.LinkedHashMap;
import java.util.Scanner;

public class EP10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> statistics = new LinkedHashMap<>();

        String line = "";
        while (!"report".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            Integer population = Integer.parseInt(tokens[2]);

            statistics.putIfAbsent(country, new LinkedHashMap<>());
            statistics.get(country).putIfAbsent(city, 0);
            statistics.get(country).put(city, statistics.get(country).get(city) + population);


        }

        statistics.entrySet()
                .stream()
                .sorted((c1,c2) -> Long.compare(c2.getValue()
                        .values()
                        .stream()
                        .mapToLong(Long::new)
                        .sum(),
                        c1.getValue()
                                .values()
                                .stream()
                                .mapToLong(Long::new)
                                .sum() ))
                .forEach(c->{
                    System.out.printf("%s (total population: %d)%n", c.getKey(), c.getValue().values().stream().mapToLong(Long::new).sum());
                    c.getValue()
                            .entrySet()
                            .stream()
                            .sorted((city1, city2)->Integer.compare(city2.getValue(), city1.getValue()))
                            .forEach(city-> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()  ));
                });
    }
}
