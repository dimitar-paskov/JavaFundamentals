package EP06GenericCountMethodDouble;


public class Box<T extends Comparable> implements Comparable<T> {
    T data;

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.data.getClass().getName(), this.data);
    }


    public int compareTo(T o) {
        return this.data.compareTo(o);
    }
}
