import java.util.Scanner;
import java.util.TreeMap;

public class EP12LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterialsMap = new TreeMap<>();
        TreeMap<String, Integer> junkMaterialsMap = new TreeMap<>();
        keyMaterialsMap.put("fragments", 0);
        keyMaterialsMap.put("shards", 0);
        keyMaterialsMap.put("motes", 0);

        String winningMaterial = "";


        lable1:
        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length-1; i = i + 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (keyMaterialsMap.containsKey(material)) {
                    keyMaterialsMap.put(material, keyMaterialsMap.get(material) + quantity);
                    if (keyMaterialsMap.get(material) >= 250) {
                        winningMaterial = material;
                        keyMaterialsMap.put(material, keyMaterialsMap.get(material) - 250);
                        break lable1;
                    }

                } else {
                    junkMaterialsMap.putIfAbsent(material, 0);
                    junkMaterialsMap.put(material, junkMaterialsMap.get(material) + quantity);
                }

            }

        }

        switch (winningMaterial) {
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }

        keyMaterialsMap.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int result = Integer.compare(e2.getValue(), e1.getValue());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                })
                .forEach(x -> {
                    System.out.printf("%s: %d\n", x.getKey(), x.getValue());
                });

        junkMaterialsMap
                .entrySet()
                .forEach(x -> {
                    System.out.printf("%s: %d\n", x.getKey(), x.getValue());
                });


    }
}
