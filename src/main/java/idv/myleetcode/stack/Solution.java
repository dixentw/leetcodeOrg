package idv.myleetcode.stack;
import java.util.*;

public class Solution{
    private boolean isOperand(char c){
        return (c>='a' && c<='z') || (c>='A'&&c<='Z');
    }
    private int prec(char a){
        switch (a){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            }
        return -1;
    }
    public String intoPost(String s){
        Stack<Character> stack = new Stack<>();
        StringBuffer result = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            char cc = s.charAt(i);
            if(isOperand(cc)){
                result.append(cc);
            }else if(cc=='('){
                stack.push(cc);
            }else if(cc==')'){
                char tmp = stack.pop();
                while(tmp!='('){
                    result.append(tmp);
                    tmp = stack.pop();
                }
            }else{//operator
                if(!stack.empty()){
                    char tmp = stack.peek();
                    while(prec(tmp)>=prec(cc)){
                        result.append(stack.pop());
                        if(stack.empty()){
                            break;
                        }
                        tmp = stack.peek();
                    }
                }
                stack.push(cc);
            }
        }
        while(!stack.empty()){
            result.append(stack.pop());
        }
        return result.toString();
    }
    public int evalPost(String input){
        Stack<Integer> s = new Stack();
        for(int i=0; i<input.length(); i++){
            char cc = input.charAt(i);
            if(cc>='0'&& cc<='9'){
                s.push(cc-'0');
            }else{
                int v1 = s.pop();
                int v2 = s.pop();
                switch(cc){
                    case '+': s.push(v2+v1);break;
                    case '-': s.push(v2-v1);break;
                    case '*': s.push(v2*v1);break;
                    case '/': s.push(v2/v1);break;
                }
            }
        }
        return s.pop();
    }
    public int[] nextGreatE(int[] A){
        int[] result = new int[A.length];
        for(int i=0; i<A.length; i++){
            boolean isTraversed = false;
            for(int j=i+1; j<A.length; j++){
                if(A[j]>A[i]){
                    result[i] = A[j];
                    isTraversed = true;
                    break;
                }
            }
            if(!isTraversed){
                result[i] = -1;
            }
        }
        return result;
    }
    //20. Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr=='('){
                stack.push(')');
            }else if(curr=='{'){
                stack.push('}');
            }else if(curr=='['){
                stack.push(']');
            }else if(stack.empty()||stack.pop()!=curr){
                return false;
            }
        }
        return stack.empty();
    }
    //71. Simplify Path
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] folders = path.split("/");
        for(String f : folders){
            if(f.equals("..") && !st.empty()){
                st.pop();
            }
            if(f.length()>0 && !f.equals("..") && !f.equals(".")){
                st.push(f);
            }
        }
        Stack<String> ret = new Stack<>();
        while(!st.empty()){
            ret.push(st.pop());
        }
        String result = "/";
        boolean in = false;
        while(!ret.empty()){
            result += ret.pop() + "/";
            in = true;
        }
        if(in){
            return result.substring(0, result.length()-1);
        }else{
            return result;
        }
    }
}
