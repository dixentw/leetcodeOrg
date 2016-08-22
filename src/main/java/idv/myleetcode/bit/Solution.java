package idv.myleetcode.bit;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
    // 137
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
}
