package EP03StackIterator;

import java.util.*;

public class Stack<T> implements Iterable<T> {

    List<T> stack;
    int top;

    Stack() {

        this.stack = new ArrayList<>();
        this.top = -1;

    }

    public void push(T[] elem) {
        if (elem != null && elem.length > 0){
            Collections.addAll(this.stack, elem);
            this.top += elem.length;
        }

    }

    public void pop() {
        if (0<= this.top){
            this.stack.remove(this.top--);
        }else{
            System.out.println("No elements");
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = stack.size()*2 -1;
            @Override
            public boolean hasNext() {
                return this.count >=0;
            }

            @Override
            public T next() {
                return stack.get((this.count--)%stack.size());
            }
        };
    }
}
