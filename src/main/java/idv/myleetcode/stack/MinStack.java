package idv.myleetcode.stack;
import java.util.*;

public class MinStack {
    private Stack<Integer> data = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public void push(int x) {
        if(x<=min) {
            data.push(min);
            min=x;
        }
        data.push(x);
    }

    public void pop() {
        if(data.peek()==min){
            data.pop();
            min=data.pop();
        }else{
            data.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min;
    }
}
