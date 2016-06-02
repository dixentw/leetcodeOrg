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
        System.out.println(x + "-" + reverse);
        if(reverse!=x){
            return false;
        }
        return true;
    }

}
