package idv.myleetcode.algo;

import java.util.*;
/**
 * Hello world!
 */
public class FloodFill{
    public static void fill(int[][] A, int X, int Y, int srcColor, int tgtColor){
        if(A[X][Y] != srcColor || A[X][Y] == tgtColor){
            return;
        }
        A[X][Y] = tgtColor;
        for(int i=X-1; i<=X+1; i++){
            for(int j=Y-1; j<=Y+1; j++){
                if(i==X && j==Y){
                    continue;
                }
                if(i>=0&&i<A.length&&j>=0&&j<A[i].length){
                    fill(A, i, j, srcColor, tgtColor);
                }
            }
        }
    }
}
