package idv.donuts;

import java.util.*;
import java.text.*;
import java.util.Date;

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
    private int goNode(boolean[][] visited, int[][] A, int i, int j, int curr){
        /*
        if(i<0|| j<0||i>=A.length||j>=A[0].length){
            return 0;
        }
        if(visited[i][j]){
            return 0;
        }
        if(A[i][j]==curr){
            visited[i][j] = true;
            goNode(visited, A, i, j+1, A[i][j]);
            goNode(visited, A, i, j-1, A[i][j]);
            goNode(visited, A, i+1, j, A[i][j]);
            goNode(visited, A, i-1, j, A[i][j]);
        }*/
        return 1;
    }
    public int solution4(int[][] A) {
        // write your code in Java SE 8
        boolean[][] visited = new boolean[A.length][A[0].length];
        int result = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[i].length; j++){
                result += goNode(visited, A, i, j, A[i][j]);
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
    public int solution(String E, String L) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try{
            Date enter = sdf.parse(E);
            Date leave = sdf.parse(L);
            long diffInSec = (leave.getTime() - enter.getTime())/1000;
            double h = (double)diffInSec/(double)(60*60);
            int ceiled = (int) Math.ceil(h);
            int result = 5;
            int remain = 0;
            if(h>1){
                remain = (ceiled-1)*4;
            }
            return result+remain;
        }catch(Exception e){
            System.out.println("error!");
            return 0;
        }
    }
    public int solution_2(String S) {
        String[] parts = S.split("[0-9]");
        int longest = -1;
        for(String part : parts){
            boolean containsCap = false;
            for(int i=0; i<part.length(); i++){
                if(part.charAt(i)>='A'&&part.charAt(i)<='Z'){
                    containsCap = true;
                }
            }
            if(containsCap){
                longest = Math.max(longest, part.length());
            }
        }
        return longest;
    }
    private int goArray(int[][] A, int startX, int startY, int tmpLen){
        int down=0,right=0;
        if(startX<A.length-1 && A[startX][startY] <= A[startX+1][startY]){
            System.out.println("intoX"+tmpLen);
            down = goArray(A, startX+1, startY, tmpLen+1);
        }
        if(startY<A[0].length-1 && A[startX][startY] <= A[startX][startY+1]){
            System.out.println("intoY"+tmpLen);
            right = goArray(A, startX, startY+1, tmpLen+1);
        }
        if(down==0&&right==0){
            return tmpLen;
        }
        return Math.max(down, right);
    }
    public int solution_3(int[][] A){
        int result = 0;
        for(int row=0; row<A.length; row++){
            for(int col=0; col<A[0].length; col++){
                int pathLen = goArray(A, row, col, 1);
                result = Math.max(pathLen, result);
            }
        }
        return result;
    }

}
