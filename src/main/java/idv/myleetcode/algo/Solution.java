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
}
