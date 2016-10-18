package idv.myleetcode.stack;
import java.util.*;

public class NestedInteger {
    int theInt;
    List<NestedInteger> theList = new ArrayList<>();
    boolean isInt = false;

    public NestedInteger(){
        isInt = true;
        theInt = 0;
    }
    public NestedInteger(int x){
        isInt = true;
        theInt = x;
    }

    public boolean isInteger(){
        return isInt;
    }
    public Integer getInteger(){
        return theInt;
    }
    public List<NestedInteger> getList(){
        return theList;
    }
    public void setInteger(int value){
        this.theInt = value;
        this.isInt = true;
    }
    public void add(NestedInteger ni){
        this.isInt = false;
        theList.add(ni);
    }

    public static NestedInteger deserialize(String s) {
        if (s.length() == 0){
            return new NestedInteger();
        }
        return myDeserialize(s, 0, s.length()-1);
    }
    private static NestedInteger myDeserialize(String s, int start, int end) {
        if (s.charAt(start) != '['){ // no sub
            return new NestedInteger(Integer.valueOf(s.substring(start, end+1)));
        }
        NestedInteger ni = new NestedInteger();
        int lvl = 0;
        int lIndex = start+1;
        for (int i=start+1 ; i<=end-1 ; i++) {
            char ch = s.charAt(i);
            if (ch == '['){
                ++lvl;
            }else if (ch == ']'){
                --lvl;
            }else if (ch == ',' && lvl == 0) {
                ni.add(myDeserialize(s, lIndex, i-1));
                lIndex = i + 1;
            }
        }
        if (lIndex <= end-1) {
            ni.add(myDeserialize(s, lIndex, end-1));
        }
        return ni;
    }
}
