package idv.myleetcode;

/**
 * Hello world!
 *
 */
public class App{
    public boolean parlindrome(String s){
        for(int i=0, j=s.length()-1; i<j; i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
