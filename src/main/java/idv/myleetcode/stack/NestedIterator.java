package idv.myleetcode.stack;
import java.util.*;

public class NestedIterator implements Iterator<Integer>{
    private Stack<NestedInteger> data = new Stack<>();

    public NestedIterator(NestedInteger nestedList) {
        if(nestedList.isInteger()){
            data.push(nestedList);
        }else{
            List<NestedInteger> tmp = nestedList.getList();
            for(int i=tmp.size()-1; i>=0; i--){
                data.push(tmp.get(i));
            }
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
