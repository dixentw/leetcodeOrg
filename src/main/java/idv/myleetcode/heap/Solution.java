package idv.myleetcode.heap;

import java.util.*;

public class Solution{

    public void maxHeapify(int[] A, int arrLen, int i){
        int cLeft = i*2+1;
        int cRight = i*2+2;
        int large = i;
        if(cLeft < arrLen && A[cLeft] > A[large]){
            large = cLeft;
        }
        if(cRight < arrLen && A[cRight] > A[large]){
            large = cRight;
        }
        if(large != i){
            int tmp = A[large];
            A[large] = A[i];
            A[i] = tmp;
            maxHeapify(A, arrLen, large);
        }
    }

    public void buildMaxHeap(int[] A){
        for(int i=(A.length-1)/2; i>=0; i--){
            maxHeapify(A, A.length, i);
        }
    }
    public void heapSort(int[] A){
        buildMaxHeap(A);
        int len = A.length-1;
        for(int i=A.length-1; i>=0; i--){
            int root = A[0];
            A[0] = A[i];
            A[i] = root;
            maxHeapify(A, len--, 0);
        }
    }
	// min heap
	public void minHeapify(int[] A, int arrLen, int i){
		int leftChild = i*2+1;
		int rightChild = i*2+2;
		int smallest = i;
		if(leftChild<arrLen&&A[leftChild]<A[smallest]){
			smallest = leftChild;
		}
		if(rightChild<arrLen&&A[rightChild]<A[smallest]){
			smallest = rightChild;
		}
		if(smallest != i){
			int tmp = A[i];
			A[i]  = A[smallest];
			A[smallest] = tmp;
			minHeapify(A, arrLen, smallest);
		}
	}
	public void buildMinHeap(int[] A) {
		int lastIdx = A.length-1;
		for(int i=lastIdx/2; i>=0; i--){
			minHeapify(A, A.length, i);
		}
	}
	public void heapSortMin(int[] A){
		buildMinHeap(A);
		for(int i=A.length-1; i>=0; i--){
			int root = A[0];
            A[0] = A[i];
            A[i] = root;
            minHeapify(A, i, 0);
		}
		System.out.println(Arrays.toString(A));
	}
	public int[] smallestRange(int[][] A ){
		int[] heap = new int[A.length];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int range = Integer.MAX_VALUE;

		for(int i=0; i<A.length; i++){
			heap[i] = A[i][0];
			max = Math.max(max, heap[i]);
		}
		buildMinHeap(heap);
		while(1){
			min = heap[0];
			range = Math.min(range, max-min+1);

		}
	}

}
