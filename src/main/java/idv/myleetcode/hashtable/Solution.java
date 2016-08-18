package idv.myleetcode.hashtable;

import java.util.*;

public class Solution{
    //299. Bulls and Cows
    public String getHint(String secret, String guess) {
        int[] secretMap = new int[10];
        int[] guessMap = new int[10];
        int bull=0, cow = 0;
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i)==guess.charAt(i)){ // if match
                bull++;
            }else{
                secretMap[secret.charAt(i)-'0']++;
                guessMap[guess.charAt(i)-'0']++;
            }
        }
        // if number appeared in guess but no secret, ignore it, but appeared in secret, need add it, can be repeat, if secret repeat
        for(int i=0; i<guessMap.length; i++){
            cow+= Math.min(secretMap[i], guessMap[i]);
        }
        return bull + "A" + cow +"B";
    }
    public String getHint2(String secret, String guess){
        int len = secret.length();
        int[] secretarr = new int[10];
        int[] guessarr = new int[10];
        int bull = 0, cow = 0;
        for (int i = 0; i < len; ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bull;
            } else {
                ++secretarr[secret.charAt(i) - '0'];
                ++guessarr[guess.charAt(i) - '0'];
            }
        }
        for (int i = 0; i < 10; ++i) {
            cow += Math.min(secretarr[i], guessarr[i]);
        }
        return "" + bull + "A" + cow + "B";
    }
    //290. Word Pattern
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length!= pattern.length()){
            return false;
        }
        Map<Character, String> table = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            String word = table.get(pattern.charAt(i));
            if(word==null){//掃一遍之前的
                if(table.containsValue(words[i])){
                    return false;
                }
                /*
                for(Character c : table.keySet()){
                    if(c!=pattern.charAt(i) && table.get(c).equals(words[i])){
                        return false;
                    }
                }*/
                table.put(pattern.charAt(i), words[i]);
            }else{
                if(!word.equals(words[i])){
                    return false;
                }
            }
        }
        return true;
    }
    //205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character aMapping = charMap.get(s.charAt(i));
            if(aMapping==null){
                if(charMap.containsValue(t.charAt(i))){
                    return false;
                }
                charMap.put(s.charAt(i), t.charAt(i));
            }else{
                if(!aMapping.equals(t.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
    //204. Count Primes
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        for(int i=2; i<n; i++){
            isPrimes[i] = true;
        }
        for(int i=2; i * i<=n; i++){
            if(!isPrimes[i]){
                continue;
            }
            for(int j=i*i; j<n; j+=i){
                isPrimes[j] = false;
            }
        }
        int result = 0;
        for(int i=2; i<n; i++){
            if(isPrimes[i]){
                result++;
            }
        }
        return result;
    }
    //36. Valid Sudoku
    public boolean isValidSudoku(char[][] board) {
        //check for row
        for(int i=0; i<board.length; i++){
            boolean[] visited = new boolean[10];
            Arrays.fill(visited, Boolean.FALSE);
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int num = board[i][j] - '0';
                if(!visited[num]){
                    visited[num] = true;
                }else{
                    return false;
                }
            }
        }
        //check for column
        for(int i=0; i<board.length; i++){
            boolean[] visited = new boolean[10];
            Arrays.fill(visited, Boolean.FALSE);
            for(int j=0; j<board[i].length; j++){
                if(board[j][i]=='.'){
                    continue;
                }
                int num = board[j][i] - '0';
                if(!visited[num]){
                    visited[num] = true;
                }else{
                    return false;
                }
            }
        }
        //check for subgrid, hard
        for(int i=0; i<board.length; i++){
            boolean[] visited = new boolean[10];
            Arrays.fill(visited, Boolean.FALSE);
            for(int j=i/3*3; j<i/3*3+3; j++){
                for(int k=(i%3)*3; k<(i%3)*3+3; k++){
                    if(board[j][k]=='.'){
                        continue;
                    }
                    int num = board[j][k] - '0';
                    if(!visited[num]){
                        visited[num] = true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //350. Intersection of Two Arrays II
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> table = new HashMap<>();
        int[] longArr;
        int[] shortArr;
        List<Integer> result = new ArrayList<>();
        if(nums1.length>nums2.length){
            longArr = nums1;
            shortArr = nums2;
        }else{
            longArr = nums2;
            shortArr = nums1;
        }
        for(int i=0; i<longArr.length; i++){
            Integer count = table.get(longArr[i]);
            if(count!=null){
                count++;
            }else{
                count = new Integer(1);
            }
            table.put(longArr[i], count);
        }
        for(int i=0; i<shortArr.length; i++){
            Integer count = table.get(shortArr[i]);
            if(count!=null&& count > 0){
                count--;
                result.add(shortArr[i]);
                table.put(shortArr[i], count);
            }
        }
        int[] rt = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            rt[i] = result.get(i);
        }
        return rt;
    }
    //3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while(end<s.length()){
            if(set.contains(s.charAt(end))){
                if(max < end - start){
                    max = end - start;
                }
                while(s.charAt(start)!=s.charAt(end)){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }else{
                set.add(s.charAt(end));
            }
            end++;
        }
        int result = Math.max(max,end-start);
        /*
        char[] cs = s.toCharArray();
        boolean[] map = new boolean[256];
        Arrays.fill(map, Boolean.FALSE);
        List<Integer> tmpRs = new ArrayList<>();
        for(int i=0; i<cs.length; i++){
            if(map[cs[i]]){
                Arrays.fill(map, Boolean.FALSE);
                tmpRs.add(i);
            }
            map[cs[i]] = true;
        }
        if(tmpRs.size()==0){
            return s.length();
        }
        if(tmpRs.size()==1){
            return (s.length() - tmpRs.get(0) > tmpRs.get(0))? s.length() - tmpRs.get(0): tmpRs.get(0);
        }
        //System.out.println(Arrays.toString(tmpRs.toArray()));
        int result = tmpRs.get(0);
        for(int i=1; i<tmpRs.size(); i++){
            int diff = tmpRs.get(i)-tmpRs.get(i-1);
            if(diff > result) {
                result = diff;
            }
        }*/
        return result;
    }
}
