import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<T> implements List<T>{
	/*These are private global variables*/
	private int size;
	private T[] arr;

	/*This is the constructor*/
	public ArrayList(){
		this.arr = (T[]) Array.newInstance(Object.class, 10);
		this.size = 0;
	}

	/*
	* The function adds an item to the last index of the array. If there is no space in the array, the
	* function will double in size.
	*
	* @param item. Item that will be added to the end of the array
	*  */
	public void add(T item){
		if(this.size + 1 == arr.length){
			double_array();
		}

		this.arr[this.size++] = item;
	}

	/*
	* The function adds an item to the array at a specific position.
	*
	* @param pos. The specific location that the item will be added to in the array
	* @param item. The item that will be added to the array.
	* */
	public void add(int pos, T item){
		//if statement checks if the position exists in the array
		if(this.size < pos || pos < 0){
			return;
		}

		if(this.size + 1 == arr.length){
			double_array();
		}

		this.arr[pos] = item;
		this.size++;
	}

	/*
	* The function returns the value that was stored in that position in the array.
	*
	* @param pos. The position's value that will be returned.
	* */
	public T get(int pos){
		//if statement checks if the position exists in the array
		if(this.size < pos || pos < 0){
			return (T) "Position not found in ArrayList";
		}

		/*The big boy stuff*/
		//Returns the value stored in that specific position
		return arr[pos];
	}

	/*
	* The function removes a position in the array. The array then decrements in size and every item from the
	* right of that position shifts to the left by one.
	*
	* @param pos. The position that will get removed
	* */
	public T remove(int pos){
		//if statement checks if the position exists in the array
		if(this.size < pos || pos < 0){
			return (T) "Position not found in ArrayList";
		}
		T item = this.arr[pos];

		/*The big boy stuff*/
		/*Every item from the right of the position gets shifted to the left by one.*/
		for(int i = pos; i < this.size; i++){
			this.arr[i] = this.arr[i+1];
		}

		this.size--; //decrement the size by one because a position was removed from the array
		return item;
	}

	/*
	* The function returns the size of the array
	* */
	public int size(){
		return this.size;
	}

	/*
	* When the function is called, the function doubles the size of the existing array. It allows more
	* items to be added to the array.
	* */
	private void double_array(){
		this.arr = Arrays.copyOfRange(this.arr, 0, arr.length * 2);
	}
}