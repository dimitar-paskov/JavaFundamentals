import java.io.Serializable;

public class Cube implements Serializable {
    String color;
    Double width;
    Double height;
    Double depth;

    public Cube(String color, Double width, Double height, Double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}
