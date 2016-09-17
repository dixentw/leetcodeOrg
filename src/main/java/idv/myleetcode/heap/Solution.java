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

}
