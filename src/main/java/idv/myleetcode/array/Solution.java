package idv.myleetcode.array;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
    // 1. two sum
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> numbers = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            numbers.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            int search = target - nums[i];
            Integer idx = numbers.get(search);
            if(idx == null){
                continue;
            }else{
                return new int[]{idx, i};
            }
        }
        return new int[0];
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
    private int thirdImpl(int[] nums){
        int top = 0;
        int num = 0;
        for(int i=0; i<nums.length;i++){
            if(num==0){
                top = nums[i];
            }else{
                if(top==nums[i]){
                    num++;
                }else{
                    num--;
                }
            }
        }
        return top;
    }
    public int majorityElement(int[] nums) {
        //return secondImpl(nums);
        return thirdImpl(nums);
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
    // 122. Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] prices){
        if(prices.length<2){
            return 0;
        }
        if(prices.length==2){
            if(prices[1] > prices[0]){
                return prices[1] - prices[0];
            }else{
                return 0;
            }
        }
        int profit = 0;
        int i=0;
        while(i<prices.length-2){
            int buy=0, sell=0;
            while(i<prices.length-1 && prices[i+1] < prices[i]){
                i++;
            }
            buy = i;
            System.out.println("sssss : "+buy);
            if(buy==prices.length-1){
                return profit;
            }
            i++;
            while(i<prices.length-1 && prices[i+1]> prices[i]){
                i++;
            }
            sell = i;
            System.out.println("buy : "+buy + ", sell:"+sell);
            profit += prices[sell] - prices[buy];
        }
        return profit;
    }
    // 88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalIdx = (n + m)- 1;
        int i = m-1;
        int j = n-1;
        for(int k=totalIdx; k>=0; k--){
            if(i<0){
                nums1[k] = nums2[j--];
            }else if(j<0){
                nums1[k] = nums1[i--];
            }else{
                if(nums2[j] > nums1[i]){
                    nums1[k] = nums2[j--];
                }else{
                    nums1[k] = nums1[i--];
                }
            }
        }
    }
    //118. Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows;i++){
            List<Integer> line = new ArrayList<>();
            if(i==0){
                line.add(1);
            }else if(i==1){
                line.add(1);line.add(1);
            }else{
                List<Integer> preLine = result.get(i-1);
                for(int j=0; j<=i; j++){
                    if(j==0){
                        line.add(1);
                    }else if(j==i){
                        line.add(1);
                    }else{
                        line.add(preLine.get(j-1)+preLine.get(j));
                    }
                }
            }
            result.add(line);
        }
        return result;
    }
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        for(int i=0; i<numRows;i++){
            line.add(0, 1);
            for(int j=1; j<i; j++){
                int tmp = line.get(j) + line.get(j+1);
                line.set(j, tmp);
            }
            List<Integer> clone = new ArrayList<>();
            clone.addAll(line);
            result.add(clone);
        }
        return result;
    }
    //26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int prev = nums[0];
        int prevIdx = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=prev){
                prev = nums[i];
                nums[prevIdx] = nums[i];
                prevIdx++;
            }
        }
        return prevIdx;
    }
    //46. Permutations
    public void permuteHelper(List<Integer> selected, List<Integer> remainds, List<List<Integer>> result){
        if(remainds.size()==0){
            result.add(selected);
        }else{
            for(int i=0; i<remainds.size(); i++){
                List<Integer> sCopy = new ArrayList<>(selected);
                List<Integer> rCopy = new ArrayList<>(remainds);
                Integer elem = rCopy.remove(i);
                sCopy.add(elem);
                permuteHelper(sCopy, rCopy, result);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permuted = new ArrayList<>();
        List<Integer> numsArray = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            numsArray.add(nums[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(permuted, numsArray, result);
        return result;
    }
    //46. Permutations 2
    public void permuteHelper2(int[] nums,List<Integer> path, List<List<Integer>> result){
        int len = nums.length;
        if(path.size()==len){// meet final, copy path and output
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=0; i<len; i++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            permuteHelper2(nums, path, result);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length==0){
            return result;
        }
        permuteHelper2(nums, new ArrayList<Integer>(), result);
        return result;
    }
    //47. Permutations 2
    public void permuteUniqueHelper(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] visited){
        int len = nums.length;
        if(path.size()==len){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=0; i<len; i++){
            if(visited[i] || (i!=0 && visited[i-1] && nums[i]==nums[i-1])){
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            permuteUniqueHelper(nums, path, result, visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        permuteUniqueHelper(nums, new ArrayList<Integer>(), result, visited);
        return result;
    }

    //349 intersection
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<Integer>();
        Set<Integer> tmp1 = new HashSet<Integer>();
        for(Integer i : nums1){
            tmp1.add(i);
        }
        for(Integer i : nums2){
            if(tmp1.contains(i)){
                result.add(i);
            }
        }
        int[] rt = new int[result.size()];
        int i=0;
        for(Integer e : result){
            rt[i] = e;
            i++;
        }
        return rt;
    }
    // anagram
    public boolean isAnagram(String s, String t){
        char[] schars = s.replaceAll("\\s", "").toCharArray();
        char[] tchars = t.replaceAll("\\s", "").toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        if(schars.length != tchars.length){
            return false;
        }else{
            for(int i=0; i<schars.length; i++){
                if(schars[i]!=tchars[i]){
                    return false;
                }
            }
            return true;
        }
    }
    //plus one
    public int[] plusOne(int[] digits){
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i]+1==10){
                digits[i]=0;
                if(i==0){
                    int[] result = new int[digits.length+1];
                    result[0]=1;
                    return result;
                }
            }else{
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }
    // 217 contains duplicate
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i< nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    //283 move Zeroes
    public void moveZeros(int[] nums){
        int head = 0;
        int tmp = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                tmp = nums[head];
                nums[head] = nums[i];
                nums[i] = tmp;
                head++;
            }
        }
    }
    // 171
    public int columnNumber(String s){
        int result = 0;
        int counter = 0;
        for(int i=s.length()-1; i>=0; i++){
            int diff = s.charAt(i) - 'A' + 1;
            result += diff * Math.pow(26, counter);
            counter++;
        }
        return result;
    }
    //90. Subsets II
    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] S, int pos){
        res.add(tmp);
        for(int i=pos; i<S.length; i++){
            List<Integer> p = new ArrayList<>(tmp);
            p.add(S[i]);
            helper(res, p, S, i+1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
        helper(res, tmp, nums, 0);
        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> l = new ArrayList<>(result.get(i));
                l.add(n);
                result.add(l);
            }
        }
        return result;
    }
    //153 find minimum in rotated sorted array
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high && nums[low] >= nums[high]) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
            }
            return nums[low];
    }
    public String reverse(String s){
        char[] arrayc = s.toCharArray();
        int start = 0;
        int end = arrayc.length-1;
        while(start<end){
            char tmp;
            tmp = arrayc[end];
            arrayc[end] = arrayc[start];
            arrayc[start] = tmp;
            start++;
            end--;
        }
        return new String(arrayc);
    }
}
