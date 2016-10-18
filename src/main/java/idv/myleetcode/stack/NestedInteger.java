package idv.myleetcode.stack;
import java.util.*;

public class NestedInteger {
    int theInt;
    List<NestedInteger> theList = new ArrayList<>();
    boolean isList = false;

    public NestedInteger(int... x){
        if(x.length>1){
            isList = true;
            for(int data : x){
                NestedInteger ni = new NestedInteger(data);
                theList.add(ni);
            }
        }else if(x.length==1){
            isList = false;
            theInt = x[0];
        }
    }
    public boolean isInteger(){
        return !isList;
    }
    public Integer getInteger(){
        return theInt;
    }
    public List<NestedInteger> getList(){
        return theList;
    }
}
