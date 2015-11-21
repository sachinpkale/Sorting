public class HeapSort {
	
	public static class Heap<E extends Comparable<E>> {
		
		Object[] values;
		int limit;
		
		public Heap() {
			this.values = new Object[100];
			this.limit = 0;
		}
		
		public void add(E value) {
			values[limit] = value;
			limit++;
		}
		
		public void buildMinHeap() {
			for(int i = limit /2 + 1; i >= 0; i--) {
				heapify(i, limit);
			}
		}

		@SuppressWarnings("unchecked")
		public void heapSort() {
			int tempLimit = limit;
			for(int i = 0; i < limit; i++) {
				E temp = (E) values[0];
				values[0] = values[tempLimit - 1];
				values[tempLimit -1] = temp;
				tempLimit--;
				heapify(0, tempLimit);
			}
		}

		@SuppressWarnings("unchecked")
		private void heapify(int index, int limit) {
			if(index < limit) {
				int left = index * 2 + 1;
				int right = index * 2 + 2;
				int largest = index;
				if(left < limit) {
					if(((E)values[left]).compareTo(((E)values[largest])) < 0) {
						largest = left;
					}
				}
				if(right < limit) {
					if(((E)values[right]).compareTo(((E)values[largest])) < 0) {
						largest = right;
					}
				}
				if(largest != index) {
					E temp = (E) values[largest];
					values[largest] = values[index];
					values[index] = temp;
					heapify(largest, limit);
				}
			}
		}

	}
	
    public static void main(String args[]) {
        HeapSort.Heap<Integer> heap = new HeapSort.Heap<Integer>();
        heap.add(12);
        heap.add(8);
        heap.add(14);
        heap.add(13);
        heap.add(6);
        heap.add(10);
        
        for(int i = 0; i < heap.limit; i++) {
        	System.out.print(heap.values[i] + ", ");
        }
        
        heap.buildMinHeap();
        System.out.println();
        
        for(int i = 0; i < heap.limit; i++) {
        	System.out.print(heap.values[i] + ", ");
        }

        heap.heapSort();
        System.out.println();
        
        for(int i = 0; i < heap.limit; i++) {
        	System.out.print(heap.values[i] + ", ");
        }        
        System.out.println();
    }
    
}
