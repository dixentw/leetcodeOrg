package idv.myleetcode.algo;

import java.util.*;

public class Gfg{
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
    public void bubbleSort(int[] A){
        for(int i=0; i<A.length-1; i++){
            for(int j=0; j<A.length-1-i;j++){
                if(A[j]>A[j+1]){
                    int tmp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = tmp;
                }
            }
        }
    }
    public void insertionSort(int[] A){
        for(int i=1; i<A.length-1; i++){
            int key = A[i];
            int j = i-1;
            while(j>=0 && A[j]> key){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = key;
        }
    }
    public void selectionSort(int[] A){
        for(int i=0; i<A.length; i++){
            int minIdx = i;
            for(int j=i+1; j<A.length; j++){
                if(A[j] < A[minIdx]){
                    minIdx = j;
                }
            }
            int tmp = A[minIdx];
            A[minIdx] = A[i];
            A[i] = tmp;
        }
    }
    private int qHelper(int[] A, int start, int end){
        int pivot = A[end];
        int i = start;
        for(int j=start; j<end; j++){
            if(A[j] < pivot){
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
                i++;
            }
        }
        int tmp = A[i];
        A[i] = A[end];
        A[end] = tmp;
        return i;
    }
    public void quickSort(int[] A, int start, int end){
        if(start < end){
            int mid = qHelper(A, start, end);
            quickSort(A, start, mid-1);
            quickSort(A, mid+1, end);
        }
    }
    public void bucketSort(float[] A, int n){
        List<List<Float>> buckets = new ArrayList<>();
        for(int i=0; i<n; i++){
            buckets.add(new ArrayList<Float>());
        }
        for(int i=0; i<A.length; i++){
            // assume that all elements distributed in 0~1
            int bi = (int)(n * A[i]);
            buckets.get(bi).add(A[i]);
        }
        for(int i=0; i<n; i++){
            List<Float> tmp = buckets.get(i);
            Collections.sort(tmp);
        }
        for(int i=0; i<n; i++){
            List<Float> tmp = buckets.get(i);
        }
        int j=0;
        for(int i=0; i<n; i++){
            List<Float> tmp = buckets.get(i);
            for(Float f : tmp){
                A[j++] = f;
            }
        }
    }
}
