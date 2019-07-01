import java.io.Serializable;

public class Course implements Serializable {
    String name;
    Integer count;

    public Course(String name, Integer count) {
        this.name = name;
        this.count = count;
    }
}
