package EP07CustomList;

import java.util.ArrayList;

public class CustomArrayLis<T extends Comparable<T>>{
	private ArrayList<T> arr;
	
	public CustomArrayLis(){
		this.arr = new ArrayList<>();
		
	}
	


	
	public int getCount() {
		return this.arr.size();
	}


	public T get(int index) {

			return this.arr.get(index);

	}


	public void add(T element) {
		this.arr.add(element);

	}





	public T remove(int index) {
		T elem = this.arr.remove(index);
		return elem;
	}


	public boolean contains(T element){
		boolean result = false;
		for (int i = 0; i < this.arr.size(); i++) {
			if (this.arr.get(i).compareTo(element)==0){
				result = true;
				break;
			}
		}

		return result;
	}

	public void swap(int index1, int index2){
		T temp = this.arr.get(index1);
		this.arr.set(index1, this.arr.get(index2));
		this.arr.set(index2, temp);
	}

	public int countGreaterThan(T element){
		int result = 0;
		for (int i = 0; i < this.arr.size(); i++) {
			if (this.arr.get(i).compareTo(element) > 0){
				result++;
			}
		}

		return result;
	}

	public T getMax(){
		T max = this.arr.get(0);

		for (int i = 1; i < this.arr.size(); i++) {
			if (this.arr.get(i).compareTo( max) > 0){
				max = this.arr.get(i);
			}

		}

		return max;
	}

	public T getMin(){
		T min = this.arr.get(0);

		for (int i = 1; i < this.arr.size(); i++) {
			if (this.arr.get(i).compareTo( min) < 0){
				min = this.arr.get(i);
			}

		}

		return min;
	}
	
}
