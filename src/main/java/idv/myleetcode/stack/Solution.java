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
    //150. Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b+a);
            }else if(token.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }else if(token.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    //394. Decode String
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k=0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k=k*10+c-'0';
            }else if(c=='['){
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            }else if(c==']'){
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for(k= intStack.pop(); k>0; k--){
                    cur.append(tmp);
                }
            }else{
                cur.append(c);
            }
        }
        return cur.toString();
    }
    public String decodeString2(String s) {
        String result = "";
        if(!s.contains("]")){
            return s;
        }else{
            Stack<Integer> st = new Stack<>();
            int k = 0;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    if(st.empty()){
                        k=k*10+c-'0';
                    }
                }else if(c=='['){
                    st.push(i);
                }else if(c==']'){
                    int left = st.pop()+1;
                    if(st.empty()){//meet outside of parentheses
                        String inner = decodeString2(s.substring(left, i));
                        for(int j=0; j<k; j++){
                            result += inner;
                        }
                        k=0;
                    }
                }else{
                    if(st.empty()){
                        result += c;
                    }
                }
            }
        }
        return result;
    }
    //402. Remove K Digits
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        if(k==num.length()){
            return "0";
        }
        int i=0;
        while(i<num.length()){
            while(k>0&&!stack.empty()&&stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.empty()){
            sb.insert(0, stack.pop());
        }
        for(i=0; i<sb.length(); i++){
            if(sb.charAt(i)!='0'){
                sb.delete(0, i);
                break;
            }
        }
        if(sb.toString().matches("[0]+")){
            return "0";
        }
        return sb.toString();
    }
    //42. Trapping Rain Water
    //can improved to merge vally?
    public int trap_old(int[] height) {
        if(height.length <=2){
            return 0;
        }
        int result = 0;
        List<Integer> peaks = new ArrayList<>();
        for(int i=0; i<height.length; i++){
            //if(i+1==height.length && height[i-1]<height[i]){
            //    peaks.add(i);
            if(i<height.length-1 && height[i]!=height[i+1]){
                peaks.add(i);
            }
        }
        List<Integer> remove = new ArrayList<>();
        //merge top
        for(int i=0; i<peaks.size(); i++){
            boolean left = false;
            boolean right = false;
            for(int j=0; j<i; j++){ //left
                if(height[peaks.get(j)]>height[peaks.get(i)]){
                    left = true;
                }
            }
            for(int j=i+1; j<peaks.size(); j++){ //right
                if(height[peaks.get(j)]>height[peaks.get(i)]){
                    right = true;
                }
            }
            if(left&&right){
                remove.add(peaks.get(i));
            }
        }
        System.out.println(Arrays.toString(remove.toArray()));
        peaks.removeAll(remove);
        System.out.println("=============");
        System.out.println(Arrays.toString(peaks.toArray()));
        for(int i=0; i<peaks.size()-1; i++){
            Integer a = peaks.get(i);
            Integer b = peaks.get(i+1);
            int min = Math.min(height[a],height[b]);
            for(int j=a+1; j<b; j++){
                int df = min - height[j];
                if(df > 0 ){
                    result += df;
                }
            }
        }
        return result;
    }
    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int result = 0;
        int l=0;
        int r=height.length-1;
        //find the leftmost and rightmost edge
        while(l<r && height[l] <= height[l+1]){
            l++;
        }
        while(l<r && height[r] <= height[r-1]){
            r--;
        }
        while(l<r){
            int left = height[l];
            int right = height[r];
            if(left<=right){
                while (l<r && left >= height[++l]) { //remove most
                    result += left - height[l];
                }
            }else{
                while(l<r && height[--r] <= right){
                    result += right - height[r];
                }
            }
        }
        return result;
    }
    //84. Largest Rectangle in Histogram
    private int largestRectangleArea_impl1(int[] heights){
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            //go right
            int j=i+1;
            if(j==heights.length||heights[i]>heights[j]){
                j=i;
            }else{
                while(j<heights.length&& heights[j] >= heights[i]){
                    j++;
                }
                j--;
            }
            //go left
            int k = i-1;
            if(k<0 || heights[k] < heights[i]){
                k=i;
            }else{
                while(k>=0 && heights[k] >= heights[i]){
                    k--;
                }
                k++;
            }
            int area = heights[i] * (j-k+1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    private int largestRectangleArea_impl3(int[] heights){
        int n = heights.length;
        int maxArea = 0, i = 0;
        Stack<Integer> stack = new Stack<>();
        while(i <= n) {
            int h = (i == n) ? 0 : heights[i];
            if(stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int j = stack.pop();
                int area = (stack.isEmpty() ? i : i-1-stack.peek()) * heights[j];
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    private int largestRectangleArea_impl2(int[] heights){
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<=heights.length; i++){
            int high = 0;
            if(i!=heights.length){
                high = heights[i];
            }
            if(s.empty() || high >= heights[s.peek()]){
                s.push(i);
            }else{
                int currHigh = heights[s.peek()];
                s.pop();
                int width = 0;
                if(s.empty()){
                    width = i;
                }else{
                    width = i - s.peek() - 1;
                }
                maxArea = Math.max(maxArea, width*currHigh);
                i--;
            }
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        return largestRectangleArea_impl2(heights);
    }
}
