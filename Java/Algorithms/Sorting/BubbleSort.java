import java.util.Arrays;

public class BubbleSort {
	public static void bubbleSort(int[] array){
		boolean swapped;
		for (int i = 0; i < array.length-1; i++) {
			swapped = false;
			for (int j = i+1; j < array.length; j++) {
				if(array[i]>array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					swapped = true;
				}
			}
			if(!swapped){break;}
		}
	}
	public static void main(String[] args) {
		int[] exampleArray = {10,7,40,3,12,-4,30,-10,0,100,3};
		System.out.println(Arrays.toString(exampleArray)); 
		bubbleSort(exampleArray);
		System.out.println(Arrays.toString(exampleArray));
	}
}