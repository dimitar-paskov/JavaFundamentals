package EP08CustomListSorter;

public class Sorter {
    public static<T extends Comparable> void sort(CustomArrayLis<T> arr){
        int n = arr.getCount();
        for (int i=1; i<n; ++i)
        {
            T key = arr.get(i);
            int j = i-1;
            while (j>=0 && arr.get(j).compareTo(key) > 0)
            {
                arr.set(j+1, arr.get(j));
                j = j-1;
            }
            arr.set(j+1, key);
        }


    }
}
