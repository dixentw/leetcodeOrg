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
}
