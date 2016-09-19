package idv.myleetcode.algo;

import java.util.*;

public class BackTrack {
    public void greeting(String s){
        System.out.println("fuck you, " + s);
    }
    // so simple, didn't know how to map to backtrack
    public void strpermHelp(String prefix, String remainds){
        int n = remainds.length();
        if(n==0){
            System.out.println(prefix);
        }else{
            for(int i=0; i< n; i++){
                strpermHelp(prefix+remainds.charAt(i), remainds.substring(0, i) + remainds.substring(i+1, n));
            }
        }
    }
    public void strperm(String input){
        strpermHelp("", input);
    }
    //more advance with backtrack
    private void helper(char[] data, boolean[] visited, String temp, List<String> result){
        if(temp.length()==data.length){
            result.add(temp);
            return;
        }
        for(int i=0; i<data.length; i++){
            if(!visited[i]){
                visited[i] = true;
                temp += data[i];
                helper(data, visited, temp, result);
                temp = temp.substring(0, temp.length()-1);
                visited[i] = false;
            }
        }
    }
    public List<String> strperm2(String input){
        List<String> result = new ArrayList<>();
        char[] data = input.toCharArray();
        boolean[] visited = new boolean[data.length];
        helper(data, visited, "", result);
        return result;
    }
    //back track remove duplicate
    private void helperUniqle(char[] data, boolean[] visited, String temp, List<String> result){
        if(temp.length()==data.length){
            result.add(temp);
            return;
        }
        for(int i=0; i<data.length; i++){
            if(visited[i] || (i!=0 && visited[i-1] && data[i]==data[i-1])){
                continue;
            }
            visited[i] = true;
            temp += data[i];
            helperUniqle(data, visited, temp, result);
            temp = temp.substring(0, temp.length()-1);
            visited[i] = false;
        }
    }
    public List<String> strpermUnique(String input){
        List<String> result = new ArrayList<>();
        char[] data = input.toCharArray();
        Arrays.sort(data);
        boolean[] visited = new boolean[data.length];
        helperUniqle(data, visited, "", result);
        return result;
    }
}
