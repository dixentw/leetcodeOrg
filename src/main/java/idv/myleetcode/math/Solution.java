package idv.myleetcode.math;

public class Solution{

    public double powHelper(double x, int n){
        if(n==0){
            return 1;
        }
        double v = powHelper(x, n/2);
        if(n%2==0){
            return v * v;
        }else{
            return v * v * x;
        }
    }
    public double pow(double x, int n){
        if(n < 0){
            return 1 / powHelper(x, n);
        }else{
            return powHelper(x, n);
        }
    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    //implement 2
    public boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }
        int reverse = 0;
        int num = x;
        while(num>0){
            reverse = reverse*10 + num%10;
            num = num/10;
        }
        if(reverse!=x){
            return false;
        }
        return true;
    }

    // 67. Add Binary
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int i=ca.length-1;
        int j=cb.length-1;
        int carry = 0;
        while(i>=0 || j>=0 || carry > 0){
            int tmpA, tmpB;
            if(i<0){
                tmpA = 0;
            }else{
                tmpA = ca[i] - '0';
            }
            if(j<0){
                tmpB = 0;
            }else{
                tmpB = cb[j] - '0';
            }
            sb.insert(0, (tmpA+tmpB+carry)%2);
            carry = (tmpA+tmpB+carry)/2;
            i--;
            j--;
        }
        return sb.toString();
    }
    // 172. Factorial Trailing Zeroes
    // 要這麼多階乘的結果的0的個數, 0來自於10, 10來自於5, 因為2的個數一定比五多，所以把所有的五collect起來就行了。
    public int trailingZeroes(int n) {
        int i = 0;
        int fives = 5;
        while(n>fives){
            i += n/fives;
            fives = fives * 5;
        }
        return i;
    }
    // 191. Number of 1 bits
    // 把所有的1 都收集起來，這題的重點在於要可以先把input轉成unsigned number, 所以開了一個long的型態
    // 去交集N, 0就還會是0,數值不變，但不會被整數的upper bound整到
    public int hammingWeight(int n) {
        long tmp = 0xffffffffL & n;
        int result = 0;
        while(tmp>0){
            if(tmp%2==1){
                result++;
            }
            tmp = tmp/2;
        }
        return result;
    }
}
