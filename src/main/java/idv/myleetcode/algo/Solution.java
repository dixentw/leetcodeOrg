package idv.myleetcode.algo;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
    private boolean[] visited;
    public Solution(int size){
        visited = new boolean[size];
    }
    public void ddfs(ArrayList<ArrayList<Integer>> adj, int s){
        if(!visited[s]){
            visited[s] = true;
            System.out.print(s+" ");
            for(int w : adj.get(s)){
                ddfs(adj, w);
            }
        }
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int s){
        Stack<Integer> st = new Stack<Integer>();
        st.push(s);
        while(!st.isEmpty()){
            int v = st.pop();
            if(!visited[v]){
                visited[v] = true;
                System.out.print(v + " ");
                ArrayList<Integer> neightbors = adj.get(v);
                Collections.reverse(neightbors);
                for(int w : neightbors){
                    if(!visited[w]){
                        st.push(w);
                    }
                }
            }
        }
        System.out.println();
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
}
