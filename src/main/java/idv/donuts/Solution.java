package idv.donuts;

import java.util.*;

public class Solution{
    public void hello(){
        System.out.println("Hello!");
    }
    public int solution1(int[] A) {
        int sumOfPrev = 0;
        int sumOfNext = 0;
        // write your code in Java SE 8
        for(int i=0; i<A.length; i++){
            sumOfNext += A[i];
        }
        for(int i=0; i<A.length; i++){
            if(i!=0){
                sumOfPrev += A[i-1];
            }
            sumOfNext -= A[i];
            System.out.println(sumOfPrev + " "+sumOfNext);
            if(sumOfPrev==sumOfNext){
                return i;
            }
        }
        return -1;
    }
    public int solution2(int N) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        int digitNum = 0;
        while(N > 0){
            int digit = N%10;
            if(table.containsKey(digit)){
                int count = table.get(digit);
                count++;
                table.put(digit, count);
            }else{
                table.put(digit, 1);
            }
            N = N/10;
            digitNum++;
        }
        int sum = 1;
        for(int i=1; i<=digitNum;i++){
            sum = sum * i;
        }
        for(Integer k : table.keySet()){
            if(table.get(k)!=1){
                sum = sum / table.get(k);
            }
        }
        return sum;
    }
    public int solution3(int[] A) {
        Arrays.sort(A);
        int largeIdx = 1;
        int maxSame = 0;
        for(int i=1; i<A.length; i++){
            if(A[i]==A[i-1]){
                largeIdx++;
            }else{
                if(A[i]-A[i-1]==1){
                    largeIdx++;
                    maxSame = Math.max(maxSame, largeIdx);
                }
                largeIdx = 1;
            }
        }
        if(maxSame!=0){
            return maxSame;
        }else{
            return -1;
        }
    }
    private int goNode(int[][] visited, int[][] A, int i, int j, int neightbor, int result){
        if(i<0|| j<0||i>A.length||j>A[0].length){
            return result;
        }
        if(visited[i][j]){
            return result;
        }
        if(neightbor!=A[i][j]){
            return result+1;
        }else{
            visited[i][j] = true;
            goNode(visited, A, i, j+1, A[i][j], result);
            goNode(visited, A, i, j-1), A[i][j], result);
            goNode(visited, A, i+1, j, A[i][j], result);
            goNode(visited, A, i-1, j, A[i][j], result);
        }
    }
    public int solution4(int[][] A) {
        // write your code in Java SE 8
        boolean[][] visited = new boolean[A.length][A[0].length];
        int result = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[i].length; j++){
                if(!visited[i][j]){
                    result++;
                    visited[i][j] = true;
                }
                //find left
                if(j-1>0){
                    if(A[i][j-1]!=A[i][j]){
                        if(!visited[i][j-1]){
                            result++;
                        }
                    }
                    visited[i][j-1] = true;
                }
                //find right
                if(j+1<A[i].length){
                    if(A[i][j+1]!=A[i][j]){
                        if(!visited[i][j+1]){
                            result++;
                        }
                    }
                    visited[i][j+1] = true;
                }
                //find bottom
                if(i+1<A.length){
                    if(A[i+1][j]!=A[i][j]){
                        if(!visited[i+1][j]){
                            result++;
                        }
                    }
                    visited[i+1][j] = true;
                }
                //find up
                if(i-1>0){
                    if(A[i-1][j]!=A[i][j]){
                        if(!visited[i-1][j]){
                            result++;
                        }
                    }
                    visited[i-1][j] = true;
                }
            }
        }
        return result;
    }
    int solution5(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        //init adjenct
        System.out.println(result);
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            r = Math.max(r, count);
        }
        System.out.println(r);
        return result + r;
    }
    public int solution6(int[] A) {
        Arrays.sort(A);
        for(int i=A.length-1; i>=2;i--){
            if(A[i]>=A[i-1]+A[i-2]){
                continue;
            }else{
                return A[i]+A[i-1]+A[i-2];
            }
        }
        return -1;
    }

}
