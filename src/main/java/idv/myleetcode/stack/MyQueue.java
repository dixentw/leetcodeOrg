package idv.myleetcode.stack;
import java.util.*;

public class MyQueue {
    Stack<Integer> dataIn = new Stack<Integer>();
    Stack<Integer> dataOut = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        dataIn.push(x);
    }
    // Removes the element from in front of queue.
    private void moveData(){
        if(dataOut.isEmpty()){
            while(!dataIn.isEmpty()){
                dataOut.push(dataIn.pop());
            }
        }
    }
    public void pop() {
        moveData();
        if(!dataOut.isEmpty()){
        	dataOut.pop();
        }
    }

    // Get the front element.
    public int peek() {
        moveData();
        if(!dataOut.isEmpty()){
        	return dataOut.peek();
        }else{
        	return 0;
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return dataOut.isEmpty() && dataIn.isEmpty();
    }
}
