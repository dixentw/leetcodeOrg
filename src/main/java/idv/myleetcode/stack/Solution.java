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
}
