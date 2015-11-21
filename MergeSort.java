public class MergeSort {
	public static void main(String[] args) {
		int arr[] = {12, 8, 14, 13, 6, 10};
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		MergeSort m = new MergeSort();
		int result[] = m.mergesort(arr, 0, arr.length);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
		System.out.println();
	}   
	
	public int[] mergesort(int [] arr, int start, int end) {
		if(start + 1 == end) {
			int[] r = {arr[start]};
			return r;
		}
		int middle = start + (end - start) / 2;
		int[] left = mergesort(arr, start, middle);
		int[] right = mergesort(arr, middle, end);
		return merge(left, right);
	}
	
	public int[] merge(int [] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int count = 0;
		while(i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				result[count] = left[i];
				i++;
			} else {
				result[count] = right[j];
				j++;				
			}
			count++;
		}
		while(i < left.length) {
			result[count++] = left[i++];			
		}
		while(j < right.length) {
			result[count++] = right[j++];			
		}
		return result;
	}
}