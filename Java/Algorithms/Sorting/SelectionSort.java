import java.util.Arrays;

public class SelectionSort {
	public static void selectionSort(int[] array){
		for (int i = 0; i < array.length-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < array.length; j++) {
				if(array[minIndex]>array[j]){
					minIndex = j;
				}
			}
			if(minIndex!=i){
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] exampleArray = {10,7,40,3,12,-4,30,-10,0,100,3};
		System.out.println(Arrays.toString(exampleArray)); 
		selectionSort(exampleArray);
		System.out.println(Arrays.toString(exampleArray));
	}
}