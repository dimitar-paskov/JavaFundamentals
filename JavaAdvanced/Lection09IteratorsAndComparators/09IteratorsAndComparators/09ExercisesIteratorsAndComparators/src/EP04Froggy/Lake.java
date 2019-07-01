package EP04Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    List<Integer> list;

    Lake(Integer[] arr){
        this.list = Arrays.asList(arr);

    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            int counter = 0;
            int index = 0;
            @Override
            public boolean hasNext() {
                return this.counter < list.size();
            }

            @Override
            public Integer next() {
                int realIndex = index;
                if (index+2 < list.size()){
                    index +=2;
                }
                else{
                    index = 1;
                }
                this.counter++;
                return list.get(realIndex);
            }
        };
    }
}
