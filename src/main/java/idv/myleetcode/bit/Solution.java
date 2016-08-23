package idv.myleetcode.bit;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
    // 137
    public int getAppear2(int[] A){
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                int num = A[j];
                if (((num >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result = result | ((count[i] % 3) << i);
        }
        return result;
    }
    public int getAppear1(int[] nums){
        int one = 0;
        int two = 0;
        int mask;
        for(int i=0; i<nums.length; i++){
            two = two | (one & nums[i]);
            one = one ^ nums[i];
            mask = ~(one & two);
            one = mask & one;
            two = mask & two;
        }
        return one;
    }
    //190. Reverse Bits
    public int reverseBit(int a){
        int result = 0;
        for(int i=0; i<32; i++){
            int b = (a >> i) & 1 ;
            result = result | (b << (31-i));
        }
        return result;
    }
    //371. sum with bits
    public int getSum(int a, int b) {
        int result = 0;
        int carryBit = 0;
        for(int i=0; i<32; i++){
            int aBit = (a >> i) & 1 ;
            int bBit = (b >> i) & 1 ;
            result = result | ( (aBit^bBit^carryBit) << i );
            carryBit = (carryBit&aBit) | (carryBit&bBit) | (aBit&bBit);
        }
        return result;
    }
    // 338. Counting Bits
    private int countB(int num){
        if(num<=0){
            return 0;
        }
        if(num%2==1){
            return 1+ countB(num/2);
        }else{
            return countB(num/2);
        }
    }
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i=0; i<=num; i++){
            result[i] = countB(i);
        }
        return result;
    }
    public int[] countBits2(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        result[1] = 1;
        int pow = 2;
        for(int i=2, t=0; i<=num; i++, t++){
            if(i==pow){
                pow = pow*2;
                t=0;
            }
            result[i] = result[t]+1;
        }
        return result;
    }

}
