package idv.myleetcode.algo;

import java.util.*;

public class MergeSort{
    public static int[] mergeSort(int[] array){
        if(array.length<=1){
            return array;
        }
        int mid = array.length/2;
        int[] tmpLeft = Arrays.copyOfRange(array, 0, mid);
        int[] tmpRight = Arrays.copyOfRange(array, mid, array.length);
        int[] sortedLeft = mergeSort(tmpLeft);
        int[] sortedRigth = mergeSort(tmpRight);
        return merge(sortedLeft, sortedRigth);
    }
    public static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int idxLeft = 0;
        int idxRight = 0;
        int idx = 0;
        while(idxLeft<left.length && idxRight<right.length){
            if(left[idxLeft] < right[idxRight]){
                result[idx++] = left[idxLeft++];
            }else{
                result[idx++] = right[idxRight++];
            }
        }
        while(idxLeft<left.length){
            result[idx++] = left[idxLeft++];
        }
        while(idxRight<right.length){
            result[idx++] = right[idxRight++];
        }
        idx++;
        return result;
    }
}
