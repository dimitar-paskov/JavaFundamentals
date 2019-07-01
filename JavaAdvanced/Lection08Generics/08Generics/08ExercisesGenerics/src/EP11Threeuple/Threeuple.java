package EP11Threeuple;

public class Threeuple<T,V,E> {
    T item1;
    V item2;
    E item3;

    public Threeuple(T item1, V item2, E item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public V getItem2() {
        return item2;
    }

    public void setItem2(V item2) {
        this.item2 = item2;
    }

    public E getItem3() {
        return item3;
    }

    public void setItem3(E item3) {
        this.item3 = item3;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        return sb.append(this.item1).append( " -> ").append(this.item2).append(" -> ").append(this.item3).toString();
//    }
}
