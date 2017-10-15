package idv.myleetcode.string;

import java.util.*;

public class Solution{
    //14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String pre = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(pre)!=0){
                pre = pre.substring(0, pre.length()-1);
            }
        }
        return pre;
    }
    //28. Implement strStr()
    public int strStr_s(String haystack, String needle) {
        for(int i=0; i<haystack.length();i++){
            boolean isDone = true;
            for(int j=0; j<needle.length();j++){
                if(i+j==haystack.length()){
                    return -1;
                }
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    isDone = false;
                    break;
                }
            }
            if(isDone){
                return i;
            }
        }
        return -1;
    }
    public int strStr(String haystack, String needle){
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
    //38. Count and Say
    public String countAndSay(int n) {
        String seed = "1";
        for(int i=1; i<n; i++){
            String tmp = "";
            for(int j=0; j<seed.length(); j++){
                int count = 1;
                while(j+1<seed.length()&&seed.charAt(j)==seed.charAt(j+1)){
                    count++;
                    j++;
                }
                tmp += String.valueOf(count)+seed.charAt(j);
            }
            seed = tmp;
        }
        return seed;
    }
    //58. Length of Last Word
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        if(words.length==0){
            return 0;
        }
        return words[words.length-1].length();
    }
    //345. Reverse Vowels of a String
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] cs = s.toCharArray();
        int start = 0;
        int end = cs.length-1;
        while(start<end){
            if(vowels.indexOf(cs[start])==-1){//not vowel
                start++;
            }
            if(vowels.indexOf(cs[end])==-1){
                end--;
            }
            if(start<end&&vowels.indexOf(cs[start])!=-1&&vowels.indexOf(cs[end])!=-1){
                char tmp = cs[start];
                cs[start++] = cs[end];
                cs[end--] = tmp;
            }
        }
        return new String(cs);
    }
    //434. Number of Segments in a String
    public int countSegments(String s) {
        s = s.trim();
        String[] data = s.split("\\s+");
        return data.length;
    }
    //383. Ransom Note
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[128];
        for(char c : magazine.toCharArray()){
            table[c]++;
        }
        for(char c: ransomNote.toCharArray()){
            table[c]--;
            if(table[c] < 0){
                return false;
            }
        }
        return true;
    }
    //5. Longest Palindromic Substring
    private int low = 0;
    private int maxLen = 0;
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        for(int i=0; i<s.length()-1; i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(low, low+maxLen);
    }
    private void extendPalindrome(String s, int start, int end){
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        // the len should be end-start+1, but we need perform end--, start++ again, so it become end-start-1
        if(end-start-1> maxLen){
            low = start+1;//not include start, since now the start break the palindrome
            maxLen = end-start-1;
        }
    }
    //6. ZigZag Conversion
    public String convert(String s, int numRows) {
        StringBuffer[] sbs = new StringBuffer[numRows];
        for(int k=0; k<numRows; k++){
            sbs[k] = new StringBuffer();
        }
        int i = 0;
        while(i<s.length()){
            for(int idx=0; idx<numRows&&i<s.length(); idx++){
                sbs[idx].append(s.charAt(i++));
            }
            for(int idx=numRows-2; idx>=1&&i<s.length(); idx--){
                sbs[idx].append(s.charAt(i++));
            }
        }
        String result = "";
        for(i=0; i<sbs.length; i++){
            result += sbs[i].toString();
        }
        return result;
    }
    //17. Letter Combinations of a Phone Number
    public List<String> letterCombinations(String digits) {
        String[] keyMap = {"","","abc", "def", "ghi","jkl","mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        comb(result, "", digits, 0, keyMap);
        return result;
    }
    private void comb(List<String> result, String prefix, String digits, int offset, String[] keyMap){
        if(offset==digits.length()){
            result.add(prefix);
            return;
        }
        String letters = keyMap[digits.charAt(offset)-'0'];
        for(int i=0; i<letters.length(); i++){
            comb(result, prefix+letters.charAt(i), digits, offset+1, keyMap);
        }
    }
    //22. Generate Parentheses
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        genP(result, "", n, n);
        return result;
    }
    private void genP(List<String> res, String tmp, int left, int right){
        if(left==0&&right==0){
            res.add(tmp);
        }
        if(left>right){
            return;
        }
        if(left>0){
            genP(res, tmp+"(", left-1, right);
        }
        if(right>0){
            genP(res, tmp+")", left, right-1);
        }
    }
    // 91. Decode Ways
    public int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) - '0' != 0 ? 1 : 0;
        for(int i=2; i<=n; i++){
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first != 0){
                dp[i] += dp[i-1];
            }
            if(second>=10 && second <=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
    // 43. Multiply Strings
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] buf = new int[m+n];
        for(int i=n-1;i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int cur = (num1.charAt(j)-'0') * (num2.charAt(i)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = cur + buf[p2];
                buf[p1] += sum/10;
                buf[p2] = sum%10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int p : buf){
            if(sb.length()==0 && p==0){
                continue;
            }
            sb.append(p);
        }
        if(sb.length()==0){
            return "0";
        }
        return sb.toString();
    }
    // 93. Restore IP Addresses
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIP(res, s, "", 0);
        return res;
    }
    private void restoreIP(List<String> res, String s, String tmp, int index){
        int dotCount = 0;
        for(int i=0; i<tmp.length(); i++){
            if(tmp.charAt(i)=='.'){
                dotCount++;
            }
        }
        if(dotCount>=3){
            if(dotCount==3&&index==s.length()){
                res.add(tmp);
            }
            return;
        }
        for(int i=1; i<4; i++){
            if(index+i > s.length()){
                continue;
            }
            String part = s.substring(index, index+i);
            if(Integer.parseInt(part) > 255){
                continue;
            }
            if(part.startsWith("0")&&part.length()>1){
                continue;
            }
            String orig = tmp;
            if(tmp.length()==0){
                tmp = part;
            }else{
                tmp = tmp+"."+part;
            }
            restoreIP(res, s, tmp, index+i);
            tmp = orig;
        }
    }
    // 165. Compare Version Numbers
    public int compareVersion(String version1, String version2) {
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");
        int shortLen = Math.min(v1Parts.length, v2Parts.length);
        for(int i=0; i<shortLen; i++){
            int v1 = Integer.parseInt(v1Parts[i]);
            int v2 = Integer.parseInt(v2Parts[i]);
            if(v1>v2){
                return 1;
            }
            if(v1<v2){
                return -1;
            }
        }
        if(v1Parts.length>v2Parts.length){
            for(int i=shortLen; i<v1Parts.length; i++){
                if(!v1Parts[i].matches("0+")){
                    return 1;
                }
            }
        }
        if(v1Parts.length<v2Parts.length){
            for(int i=shortLen; i<v2Parts.length; i++){
                if(!v2Parts[i].matches("0+")){
                    return -1;
                }
            }
        }
        return 0;
    }
    //227. Basic Calculator II
    // I need to delay the operator for get next num, so I need tmp variable outside
    public int calculate(String s) {
        if(s.length()==0) return 0;
        s = s.replace(" ", "");
        s += "$";
        Stack<Integer> numbers = new Stack<>();
        int num = 0;
        char sign = '+';
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10+ (c-'0');
            }else{
                if(sign=='+'){
                    numbers.push(num);
                }else if(sign=='-'){
                    numbers.push(-num);
                }else if(sign=='*'){
                    numbers.push(numbers.pop()*num);
                }else if(sign=='/'){
                    numbers.push(numbers.pop()/num);
                }
                num = 0;
                sign = c;
                System.out.println(sign);
            }
        }
        num = 0;
        for(Integer i : numbers){
            num += i;
        }
        return num;
    }
}
