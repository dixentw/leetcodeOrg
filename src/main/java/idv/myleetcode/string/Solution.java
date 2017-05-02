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
}
