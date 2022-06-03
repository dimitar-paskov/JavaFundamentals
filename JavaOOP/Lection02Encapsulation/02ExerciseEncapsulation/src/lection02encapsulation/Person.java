package lection02encapsulation;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) throws ValidationException {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }


    private void setName(String name) throws ValidationException {
        if (name == null || name.isEmpty() || name.trim().length() < 1) {
            throw new ValidationException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) throws ValidationException {
        if (money < 0 ) {
            throw new ValidationException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) throws ValidationException {
        if (product.getCost() <= this.money){
            this.products.add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", this.name, product.getName());
        }else{
            throw new ValidationException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");

        if (this.products.size()<1){
            sb.append("Nothing bought");
        }else {
            for (int i = 0; i < this.products.size(); i++) {
                if (i < this.products.size()-1){
                    sb.append(this.products.get(i).getName());
                    sb.append(", ");
                }else {
                    sb.append(this.products.get(i).getName());
                }
            }
        }



        return sb.toString();

    }
}
