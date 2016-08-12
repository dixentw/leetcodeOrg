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
    public int numberOfIsland(int[][] map){
        int m = map.length;
        if(m==0){
            return 0;
        }
        int result = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    continue;
                }
                result++;
                markAround(map, i, j);
            }
        }
        return result;
    }
    private void markAround(int[][] map, int x, int y){
        if(map[x][y]==0){
            return;
        }
        map[x][y] = 0;
        markAround(map, x-1,y);
        markAround(map, x,y-1);
        markAround(map, x+1,y);
        markAround(map, x,y+1);
    }

}
