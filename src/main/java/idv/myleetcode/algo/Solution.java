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
            invert = mergeSort(array, tmp, left, mid);
            invert += mergeSort(array, tmp, mid+1, right);
            invert += merge(array, tmp, left, mid+1, right);
        }
        return invert;
    }
    public int countInversion(int[] A){
        int[] tmp = new int[A.length];
        int result = mergeSort(A, tmp, 0, A.length-1);
        return result;
    }

    public String reverseSentence(String s){
        char[] cs = s.toCharArray();
        int start = 0;
        int end = 0;
        while(true){
            //System.out.println(Arrays.toString(cs));
            if(end<cs.length&&cs[end]!=' '){
                end++;
            }else{
                int inner = end-1;
                while(start<inner){//swap
                    char tmp = cs[start];
                    cs[start] = cs[inner];
                    cs[inner] = tmp;
                    start++;
                    inner--;
                }
                if(end<cs.length){
                    start = end= end+1;
                }else{
                    break;
                }
            }
        }
        return new String(cs);
    }

    //how many possible way to go n ?
    public Integer[] goBoard(int n){
        List<List<Integer>> cal = new LinkedList<>();
        cal.add(0, new LinkedList<Integer>(Arrays.asList(1)));
        cal.add(1, new LinkedList<Integer>(Arrays.asList(1)));
        for(int i=2; i<=n; i++){
            if(i >= cal.size()){
                cal.add(i, new LinkedList<Integer>(Arrays.asList(0)));
            }
            List<Integer> currentNum = cal.get(i);
            for(int j=1; j<=6; j++){
                if(i-j<1){
                    break;
                }
                List<Integer> prevNum = cal.get(i-j);
                currentNum = addTwoList(currentNum, prevNum);
            }
            currentNum = addTwoList(currentNum, new LinkedList<Integer>(Arrays.asList(1)));
            cal.add(i, currentNum);
        }
        return cal.get(n).toArray(new Integer[0]);
    }

    // fab , 0, 1, 1, 2, 3, 5
    public int fib(int n){
        int prev2 = 0;
        int prev = 1;
        if(n==0){
            return prev2;
        }
        if(n==1){
            return prev;
        }
        for(int i=2; i<=n; i++){
            int sum = prev + prev2;
            prev2 = prev;
            prev = sum;
        }
        return prev;
    }
    public Integer[] fib2(int n){
        List<Integer> prev2 = new LinkedList<>();
        List<Integer> prev = new LinkedList<>();
        prev2.add(0);
        prev.add(1);
        if(n==0){
            return prev2.toArray(new Integer[0]);
        }
        if(n==1){
            return prev.toArray(new Integer[0]);
        }
        for(int i=2; i<=n; i++){
            List<Integer> sum = addTwoList(prev2, prev);
            prev2 = prev;
            prev = sum;
        }
        return prev.toArray(new Integer[0]);
    }
    public List<Integer> addTwoList(List<Integer> a, List<Integer> b){
        List<Integer> tmp = new LinkedList<>();
        int largeLen = 0;
        int diff = Math.abs(a.size()-b.size());
        //pedding zero
        if(a.size()>b.size()){
            for(int i=0; i<diff; i++){
                b.add(0, 0);
            }
            largeLen = a.size();
        }else{
            for(int i=0; i<diff; i++){
                a.add(0, 0);
            }
            largeLen = b.size();
        }
        int carry = 0;
        for(int i=largeLen-1; i>=0; i--){
            int sum = a.get(i) + b.get(i) + carry;
            if(sum>=10){
                carry = 1;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            tmp.add(0, sum);
        }
        if(carry==1){
            tmp.add(0, carry);
        }
        return tmp;
    }
}
