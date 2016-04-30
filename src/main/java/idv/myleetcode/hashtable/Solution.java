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
}
