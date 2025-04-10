import java.util.Arrays;

public class InsertionSort {
	public static void insertionSort(int[] array){
		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int j = i-1;
			while(j>=0 && array[j]>current){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = current;
		}
	}
	
	public static void main(String[] args) {
		int[] exampleArray = {10,7,40,3,12,-4,30,-10,0,100,3};
		System.out.println(Arrays.toString(exampleArray)); 
		insertionSort(exampleArray);
		System.out.println(Arrays.toString(exampleArray));
	}
}