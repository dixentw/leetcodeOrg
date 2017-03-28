package idv.myleetcode.dp;

import java.util.*;

public class Solution{

	//322. Coin Change
    public int coinChange(int[] coins, int amount){
		if(amount<0){
			return -1;
		}
		if(amount==0){
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int im = 0;
		for(int c : coins){
			int num = coinChange(coins, amount-c);
			if(num<0){
				im++;
			}else{
				if( num < min){
					min = num;
				}
			}
		}
		if(im==coins.length){
			return -1;
		}
		return 1+min;
    }
	public int coinChange_dp(int[] coins, int amount){
		int[] result = new int[amount+1];
		for(int i=1; i<result.length; i++){
			result[i] = amount+1; // for case amount=1, coin = [1]
		}
		result[0] = 0;
		for(int i=1; i<=amount; i++){
			for(int j=0; j<coins.length;j++){
				if(coins[j]<=i){
					result[i] = Math.min(result[i], result[i-coins[j]]+1);
				}
			}
		}
		if(result[amount]>amount){
			return -1;
		}
		return result[amount];
    }
}
