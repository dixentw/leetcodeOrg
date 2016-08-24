package idv.myleetcode.algo;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
    private boolean isBadVersion(int n){
        if(n==1){
            return true;
        }else{
            return false;
        }
    }
    //binary search
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start<end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //if R1, R2 overlap, contains, or separate?
        //1. seperate :
        if(E>=C ||F>=D){
            return (C-A)*(D-B) + (G-E)*(H-F);
        }
        if(A>=G ||B>=H){
            return (C-A)*(D-B) + (G-E)*(H-F);
        }
        //2. contains or overlap:
        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(H, D);
        int bottom = Math.max(B, F);
        return (C-A)*(D-B)+(G-E)*(H-F) - (right-left) * (top-bottom);
    }
    public int doItAgagin(int A, int B, int C, int D, int E, int F, int G, int H) {
        return 0;
    }

    public int addDigit(int num){
        int sum = 0;
        do{
            int a = num % 10;
            sum += a;
            num = num/10;
        }while(num > 0);
        if(sum>=10){
            return addDigit(sum);
        }else{
            return sum;
        }
    }
    //200. Number of Islands
    public int numberOfIsland(char[][] grid){
        int m = grid.length;
        if(m==0){
            return 0;
        }
        int result = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='0'){
                    continue;
                }
                result++;
                markAround(grid, i, j);
            }
        }
        return result;
    }
    private void markAround(char[][] map, int x, int y){
        if(x<0 || y<0 || x>=map.length||y>=map[0].length){
            return;
        }
        if(map[x][y]=='1'){
            map[x][y] = '0';
            markAround(map, x-1,y);
            markAround(map, x,y-1);
            markAround(map, x+1,y);
            markAround(map, x,y+1);
        }
    }
    public void stairCase(int n){
        for(int i=0;i<n; i++){
            for(int j=n-1; j>i; j--){
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++){
                System.out.print("#");
            }
            System.out.println("");
        }
    }
    // count inversion
    private int merge(int[] a, int[] tmp, int left, int mid, int right){
        int idxLeft = left;
        int idxRight = mid;
        int idx = left;
        int invert = 0 ;
        while(idxLeft<mid && idxRight<=right){
            if(a[idxLeft] < a[idxRight]){
                tmp[idx++] = a[idxLeft++];
            }else{
                tmp[idx++] = a[idxRight++];
                invert = invert + mid-idxLeft;
            }
        }
        // add remaind array
        while(idxLeft<mid){
            tmp[idx++] = a[idxLeft++];
        }
        while(idxRight<=right){
            tmp[idx++] = a[idxRight++];
        }
        for(int i=left; i<=right; i++){
            a[i] = tmp[i];
        }
        return invert;
    }
    private int mergeSort(int[] array, int[] tmp, int left, int right){
        int invert = 0;
        int mid = 0;
        if(right>left){
            mid = (right+left)/2;
            System.out.println(left+", "+right+", "+mid);
            invert = mergeSort(array, tmp, left, mid);
            invert += mergeSort(array, tmp, mid+1, right);
            invert += merge(array, tmp, left, mid+1, right);
        }
        return invert;
    }
    public int countInversion(int[] A){
        int[] tmp = new int[A.length];
        int result = mergeSort(A, tmp, 0, A.length-1);
        System.out.println(Arrays.toString(A));
        return result;
    }

}
