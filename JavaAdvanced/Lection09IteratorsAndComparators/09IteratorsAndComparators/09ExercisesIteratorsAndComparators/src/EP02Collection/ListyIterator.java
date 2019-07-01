package EP02Collection;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterator<String>,Iterable<String>{

    List<String> list;
    int count;

    public ListyIterator(List<String> list) {
        this.list = list;
        this.count = 0;
    }

    public void print(){
        try{
            System.out.println(this.list.get(this.count));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Operation!");
        }
    }

    public boolean move(){
        if (this.count<this.list.size()-1){
            this.count++;
            return true;
        }else {
            return false;
        }
    }


    @Override
    public boolean hasNext() {
        return  this.count < this.list.size()-1;
    }

    @Override
    public String next() {
        return this.list.get(this.count++);
    }


    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < list.size() && list.get(currentIndex) != null;
            }

            @Override
            public String next() {
                return list.get(currentIndex++);
            }

        };
        return it;
    }
}
