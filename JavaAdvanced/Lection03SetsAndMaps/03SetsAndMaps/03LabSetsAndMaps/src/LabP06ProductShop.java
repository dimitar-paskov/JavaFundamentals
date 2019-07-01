import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LabP06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> markets = new TreeMap<>();
        String line= "";

        while (!"Revision".equals(line=scanner.nextLine())){
            String[] data = line.split(", ");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);


            LinkedHashMap<String, Double> products = new LinkedHashMap<>();
            if (markets.containsKey(shop)){
                products = markets.get(shop);
            }

            products.put(product, price);
            markets.put(shop, products);
        }

        for (String shop :
                markets.keySet()) {
            System.out.println(shop+"->");
            LinkedHashMap<String , Double> products = markets.get(shop);
            for (String product :
                    products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", product, products.get(product));
            }
        }
    }
}
