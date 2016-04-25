package idv.myleetcode.array;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{

    public int get10Num(){
        return 10;
    }

    // 219. contains duplicate
    public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> c = new HashSet<>();
		for(int i=0; i<nums.length; i++){
            if(i > k){
                c.remove(nums[i-k-1]);
            }
			if(!c.add(nums[i])){
				return true;
			}
		}
	   return false;
    }

    // 289. game of life
    public int getLiveNeighbor(int[][] board, int x, int y){
        int result = 0;
        for(int i=x-1; i<=x+1; i++){
            for(int j=y-1; j<=y+1; j++){
                if(i >= 0 && i < board.length && j>=0 && j<board[0].length){
                    if(board[i][j]==1){
                        result++;
                    }
                }
            }
        }
        if(board[x][y]==1){
            return result-1;
        }
        return result;
    }
    public void gameOfLife(int[][] board){
        int[][] result = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==0){ // dead
                    if(getLiveNeighbor(board, i, j)==3){
                        result[i][j] = 1;
                    }
                }else{ // live
                    int liveN = getLiveNeighbor(board, i, j);
                    System.out.println(liveN + "=" + i + "="+j );
                    if(liveN<2 || liveN>3 ){
                        result[i][j] = 0;
                    }else{
                        result[i][j] = 1;
                    }
                }
            }
        }
        //copy result back to board
        for(int i=0; i<board.length; i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = result[i][j];
            }
        }
    }
    // 217. contains duplicate 1
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0){
                if(nums[i]==nums[i-1]){
                    return true;
                }
            }
        }
        return false;
    }
    // 189. Rotate Array
    public void rotate(int[] nums, int k) {
        List<Integer> tmp = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            tmp.add(nums[i]);
        }
        for(int i=0; i<k; i++){
            Integer e = tmp.remove(tmp.size()-1);
            tmp.add(0, e);
        }
        for(int i=0; i<tmp.size(); i++){
            nums[i] = tmp.get(i);
        }
    }
    // 169. Majority Element
    private int fristImpl(int[] nums){
        Map<Integer, Integer> table = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            Integer cache = table.get(nums[i]);
            if(cache==null){
                table.put(nums[i], 1);
            }else{
                table.put(nums[i], cache+1);
            }
        }
        for(Integer e : table.keySet()){
            if(table.get(e) > nums.length/2){
                return e;
            }
        }
        return 0;
    }
    private int secondImpl(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int majorityElement(int[] nums) {
        return secondImpl(nums);
    }
    // 121. Best Time to Buy and Sell Stock
    //cannot pass time limit
    private int firstImpl121(int[] prices){
        int max = 0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                int sell = prices[j] - prices[i];
                if(sell > max){
                    max = sell;
                }
            }
        }
        return max;
    }
    private int secondImpl121(int[] prices){
        int profit = 0;
        if(prices.length<2){
            return 0;
        }else{
            int min = prices[0];
            for(int i=1; i<prices.length; i++){
                profit = Math.max(profit, prices[i] - min);
                min = Math.min(min, prices[i]);
            }
            return profit;
        }
    }
    public int maxProfit(int[] prices) {
        return secondImpl121(prices);
    }
}
