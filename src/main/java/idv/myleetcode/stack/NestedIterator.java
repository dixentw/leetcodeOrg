package idv.myleetcode.stack;
import java.util.*;

public class NestedIterator implements Iterator<Integer>{
    private Stack<NestedInteger> data = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i=nestedList.size()-1; i>=0; i--){
            data.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return data.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!data.empty()){
            NestedInteger curr = data.peek();
            if(curr.isInteger()){
                return true;
            }
            data.pop();
            for(int i=curr.getList().size()-1; i>=0; i--){
                data.push(curr.getList().get(i));
            }
        }
        return false;
    }
}
