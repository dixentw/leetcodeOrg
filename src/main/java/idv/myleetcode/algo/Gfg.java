package idv.myleetcode.algo;

import java.util.*;

public class Gfg{
    //---------------------- HEAP section -----------------------------------
    private void maxHeapify(int[] A, int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int large = i;
        if(left<A.length && A[left]>A[large]){
            large = left;
        }
        if(right<A.length && A[right]>A[large]){
            large = right;
        }
        if(large!=i){//swap happen, track down to the left
            int tmp = A[i];
            A[i] = A[large];
            A[large] = tmp;
            maxHeapify(A, large);
        }
    }
    public void buildMaxHeap(int[] A){
        for(int i=(A.length-1)/2; i>=0; i--){
            maxHeapify(A, i);
        }
    }
    public void heapSort(int[] A){
        buildMaxHeap(A);
        System.out.println(A[0]);
        for(int i=A.length-1; i>=0;i--){
            //swap A[0] with A[last], for it is max heap
            // no swap for min heap
            int tmp = A[i];
            A[i] = A[0];
            A[0] = tmp;
            maxHeapify(A, 0);
        }
    }
    public int[] getMaxN2(int[] A, int n){
        int[] result = new int[n];
        buildMaxHeap(A);
        for(int i=0; i<n; i++){
            result[i] = A[0];
            A[0] = A[A.length-(1+i)];
            A[A.length-(1+i)] = 0; //should remove, but I don't know how
            maxHeapify(A, 0);
        }
        return result;
    }
    //---------------------- HEAP section -----------------------------------
    public int[] getMaxN(int[] A, int n){
        int[] result = new int[n];
        for(int i=0; i<3; i++){
            for(int j=0; j<A.length-2;j++){
                if(A[j]>A[j+1]){
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
            }
        }
        int j = 0;
        for(int i=A.length-1; i>=A.length-n; i--){
            result[j++] = A[i];
        }
        return result;
    }
}
