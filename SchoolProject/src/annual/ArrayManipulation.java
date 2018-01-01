package annual;

public class ArrayManipulation {
	private int[] array;

	public ArrayManipulation(int[] array) {
		this.array = array;
	}

	public void removeEle(int index) {
		index--;
		int[] array = new int[this.array.length - 1];
		for (int i = 0; i < array.length; i++) {
			if (i == index)
				continue;

			array[i] = this.array[i];
		}
	}

	public void displayArray() {
		System.out.print("The array elements are : ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}
