package idv.booking;

import java.util.*;

public class Solution{
    public static void main(String[] args){
        System.out.println("oooooo");
    }
    public static String greeting(){
        return "hello booking.com";
    }
    public static void StairCase(int n) {
        for(int i=1; i<=n; i++){
            for(int j=n-i; j>0; j--){
                System.out.print(" ");
            }
            for(int k=0; k<i; k++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

}
