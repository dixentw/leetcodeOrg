package idv.myleetcode.algo;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
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
}
