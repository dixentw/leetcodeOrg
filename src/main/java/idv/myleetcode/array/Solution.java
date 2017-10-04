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
    public int[] twoSum_1(int[] nums, int target){
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            if(nums[start]+nums[end]==target){
                return new int[]{nums[start], nums[end]};
            }else if(nums[start]+nums[end]>target){
                end--;
            }else{
                start++;
            }
        }
        return new int[]{nums[start], nums[end]};
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
    public void rotate_old(int[] nums, int k) {
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
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
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
            if(buy==prices.length-1){
                return profit;
            }
            i++;
            while(i<prices.length-1 && prices[i+1]> prices[i]){
                i++;
            }
            sell = i;
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
    //119. Pascal's Triangle II
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(0, 1);
            for (int j = 1; j < result.size() - 1; j++) {
                result.set(j, result.get(j) + result.get(j + 1));
            }
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
    //27. Remove Element
    public int removeElement(int[] nums, int val) {
        int lastIdx = nums.length - 1;
        int firstIdx = 0;
        while(firstIdx <= lastIdx){
            if(nums[firstIdx]==val){
                int tmp = nums[firstIdx];
                nums[firstIdx] = nums[lastIdx];
                nums[lastIdx] = tmp;
                lastIdx--;
                firstIdx = 0;
            }else{
                firstIdx++;
            }
        }
        return lastIdx+1;
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
    private void permuteUniqueHelper(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] visited){
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
	//153 find minimum in rotated sorted array
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
		//if nums[low] < nums[high], we got it, it must be nums[low], since it sorted
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
    //15. 3Sum
    public List<List<Integer>> threeSum_old(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int begin = i+1;
            int end = nums.length-1;
            int sum = 0 - nums[i];
            while(begin<end){
                if(nums[begin]+ nums[end] ==sum){
                    result.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    begin++;
                    end--;
                    //skip duplicate
                    while(begin<end&&nums[begin]==nums[begin-1]){
                        begin++;
                    }
                    while(begin<end&&nums[end]==nums[end+1]){
                        end--;
                    }
                }else if(nums[begin]+nums[end] > sum){
                    end--;
                }else{
                    begin++;
                }
            }
        }
        return result;
    }
    //16. 3Sum Closest
    public int threeSumClosest(int[] nums, int target) {
        //init result with a arbitary range
        int result = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
                if(Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
            }
        }
        return result;
    }
    //18. 4Sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length-2; j++){
                if(j>i+1&&nums[j]==nums[j-1])continue;
                int start = j+1;
                int end = nums.length-1;
                while(start<end){
                    int sum = nums[i]+nums[j]+nums[start]+nums[end];
                    if(target==sum){
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while(start<end&&nums[start]==nums[start+1]){
                            start++;
                        }
                        while(start<end&&nums[end]==nums[end-1]){
                            end--;
                        }
                        start++;
                        end--;
                    }else if(sum<target){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return result;
    }
    //53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(sum <= 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int answer = 0;
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
    public int maxSubArray1(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    private int helper(int[] nums, int start, int end){
        if(start==end){
            return nums[start];
        }
        int mid = start + (end-start)/2;
        return Math.max(helper(nums, start, mid), Math.max(helper(nums, mid+1, end), crossHelper(nums, start, end)));
    }
    private int crossHelper(int[] nums, int start, int end){
        int mid = start + (end-start)/2;
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid; i>=start; i--){
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }
        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for(int i=mid+1; i<=end; i++){
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }
        return leftMax + rightMax;
    }
    //414. Third Maximum Number
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long second = max;
        long third = max;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                third = second;
                second = max;
                max = nums[i];
            }else if(nums[i] > second && nums[i] != max){
                third = second;
                second = nums[i];
            }else if(nums[i] > third && nums[i] != second && nums[i] != max){
                third= nums[i];
            }
        }
        if(third!=Long.MIN_VALUE){
            return (int)third;
        }else{
            return (int)max;
        }
    }
    //11. Container With Most Water
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while(start < end){
            maxArea = Math.max(maxArea, Math.min(height[start], height[end])*(end-start));
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }
    //31. Next Permutation
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i>0 && nums[i]<=nums[i-1]){
            i--;
        }
        if(i==0){
            Arrays.sort(nums);
            return;
        }
        int second = Integer.MAX_VALUE;
        int secondIdx = Integer.MAX_VALUE;
        for(int j=nums.length-1; j>=i; j--){
            if(nums[j]> nums[i-1] && nums[j] < second){
                second = nums[j];
                secondIdx = j;
            }
        }
        int tmp = nums[i-1];
        nums[i-1] = nums[secondIdx];
        nums[secondIdx] = tmp;
        Arrays.sort(nums, i, nums.length);
    }
    //34. Search for a Range
    public int[] searchRange_old(int[] nums, int target) {
		int[] result = new int[]{-1,-1};
		int start = 0;
		int end = nums.length-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(nums[mid] < target){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		if(start>nums.length-1||nums[start]!=target){
			return result;
		}
		result[0] = start;
		end = nums.length-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(nums[mid]>target){
				end = mid-1;
			}else{
				start = mid+1;
			}
		}
		if(end<0||nums[end]!=target){
			result[0] = -1;
			return result;
		}
		result[1] = end;
		return result;
    }
    //35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(target < nums[mid]){
                end = mid - 1;
            }else if(target > nums[mid]){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return Math.min(start, end)+1;
    }
    //268. Missing Number
    public int missingNumber(int[] nums) {
        int sumExpected = (nums.length+1)*(nums.length)/2;
        int sumActual = 0;
        for(int i=0; i<nums.length; i++){
            sumActual += nums[i];
        }
        return sumExpected - sumActual;
    }
    //39. Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationHelper(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    private void combinationHelper(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start){
        if(target > 0){
            for(int i=start; i<candidates.length && target>=candidates[i]; i++){
                cur.add(candidates[i]);
                combinationHelper(result, cur, candidates, target-candidates[i], i);
                cur.remove(cur.size()-1);
            }
        }
        if(target==0){
            result.add(new ArrayList<Integer>(cur));
        }
    }
    //40. Combination Sum II
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationHelper2(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    private void combinationHelper2(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start){
        if(target > 0){
            for(int i=start; i<candidates.length && target>=candidates[i]; i++){
                if(i>start&&candidates[i]==candidates[i-1]){
                    continue;
                }
                cur.add(candidates[i]);
                combinationHelper2(result, cur, candidates, target-candidates[i], i+1);
                cur.remove(cur.size()-1);
            }
        }
        if(target==0){
            result.add(new ArrayList<Integer>(cur));
        }
    }
    //48. Rotate Image
    public void rotate48(int[][] matrix) {
        int len = matrix.length;
        int[][] copy = new int[matrix.length][matrix.length];
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                //int dest = matrix[j][len-1-i];
                copy[j][len-1-i] = matrix[i][j];
            }
        }
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                matrix[i][j] = copy[i][j];
            }
        }
    }
    public void rotate48_2(int[][] matrix) {
        int len = matrix.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i=0; i<len; i++){
            for(int j=0; j<len/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = tmp;
            }
        }
    }
    //54. Spiral Matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if(m==0){
            return result;
        }
        int n = matrix[0].length;
        int u = 0;
        int d = m-1;
        int l = 0;
        int r = n-1;
        while(true){
            //swipe to right, and line++
            for(int col=l; col<=r; col++){
                result.add(matrix[u][col]);
            }
            if(++u>d){
                break;
            }
            //swipe down, and col++
            for(int row=u; row<=d; row++){
                result.add(matrix[row][r]);
            }
            if(--r<l){
                break;
            }
            //swipe left, and d--
            for(int col=r; col>=l; col--){
                result.add(matrix[d][col]);
            }
            if(--d<u){
                break;
            }
            //swipe up, and l++
            for(int row=d; row>=u; row--){
                result.add(matrix[row][l]);
            }
            if(++l>r){
                break;
            }
        }
        return result;

    }
    //55. Jump Game
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        for(int i=0; i<nums.length; i++){
            if(maxIdx<i || maxIdx>=nums.length-1){//can reach, or never reach
                break;
            }
            maxIdx = Math.max(maxIdx, nums[i]+i);
        }
        return maxIdx >= nums.length-1;
    }
    //45. Jump Game II
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int level = 0, currentMax = 0, nextMax = 0, i=0;
        while(currentMax>=i){
            level++;
            for(;i<=currentMax; i++){
                nextMax = Math.max(nextMax, nums[i]+i);
                if(nextMax>=nums.length-1){
                    return level;
                }
            }
            currentMax = nextMax;
        }
        return 0;
    }
	//59. Spiral Matrix II
	public int[][] generateMatrix(int n){
		int up = 0, right=n-1, left=0, down=n-1;
		int[][] result = new int[n][n];
		int seq = 1;
		while(true){
			for(int i=left;i<=right;i++){
				result[up][i] = seq++;
			}
			if(++up>down){
				break;
			}
			for(int i=up;i<=down;i++){
				result[i][right] = seq++;
			}
			if(--right<left){
				break;
			}
			for(int i=right;i>=left; i--){
				result[down][i] = seq++;
			}
			if(--down<up){
				break;
			}
			for(int i=down; i>=up; i--){
				result[i][left] = seq++;
			}
			if(++left>right){
				break;
			}
		}
		return result;
	}
	//62. Unique Paths
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(i==0&&j==0){
					dp[i][j] = 1;
				}else if(i==0){
					dp[i][j] = dp[i][j-1];
				}else if(j==0){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		for(int[] line : dp){
			System.out.println(Arrays.toString(line));
		}
		return dp[m-1][n-1];
    }
	//63. Unique Paths II
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for(int i=0; i<m;i++){
			for(int j=0; j<n;j++){
				if(i==0&&j==0){
					dp[0][0] = 1;
				}else if(i==0){
					if(obstacleGrid[i][j]==1){
						dp[i][j] = 0;
					}else{
						dp[i][j] = dp[i][j-1];
					}
				}else if(j==0){
					if(obstacleGrid[i][j]==1){
						dp[i][j] = 0;
					}else{
						dp[i][j] = dp[i-1][j];
					}
				}else{
					if(obstacleGrid[i][j]==1){
						dp[i][j] = 0;
					}else{
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
		}
		return dp[m-1][n-1];
    }
	//64. Minimum Path Sum
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for(int i=0; i<m;i++){
			for(int j=0; j<n;j++){
				if(i==0&&j==0){
					dp[i][j] = grid[i][j];
				}else if(i==0){
					dp[i][j] = dp[i][j-1] + grid[i][j];
				}else if(j==0){
					dp[i][j] = dp[i-1][j] + grid[i][j];
				}else{
					int min = Math.min(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = min + grid[i][j];
				}
			}
		}
		return dp[m-1][n-1];
    }
	//73. Set Matrix Zeroes
	public void setZeroes(int[][] matrix) {
		int zeroElm = 1;
		for(int i=0; i<matrix.length; i++){
			if(matrix[i][0]==0){
				zeroElm = 0;
			}
			for(int j=1; j<matrix[0].length; j++){
				if(matrix[i][j]==0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for(int k=matrix.length-1;k>=0; k--){
			for(int l=matrix[0].length-1; l>=1; l--){
				if(matrix[k][0]==0||matrix[0][l]==0){
					matrix[k][l] = 0;
				}
			}
			if(zeroElm==0){
				matrix[k][0] = 0;
			}
		}
    }
	//74. Search a 2D Matrix
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		if(rows==0){
			return false;
		}
		int cols = matrix[0].length;
		int start = 0;
		int end = (cols * rows)-1;
		while(start<=end){
			int mid = (start+end)/2;
			int num = matrix[mid/cols][mid%cols];
			if(num<target){
				start = mid+1;
			}else if(num> target){
				end = mid-1;
			}else{
				return true;
			}
		}
		return false;
    }
	//75. Sort Colors
	public void sortColors(int[] nums) {
		int r=0, w=0, b=0;
		for(int i=0; i<nums.length;i++){
			if(nums[i]==0){
				nums[b++] = 2;
				nums[w++] = 1;
				nums[r++] = 0;
			}else if(nums[i]==1){
				nums[b++] = 2;
				nums[w++] = 1;
			}else if(nums[i]==2){
				nums[b++] = 2;
			}
		}
	}
	//78. Subsets
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		subHelper(result, nums, new ArrayList<Integer>(), 0);
		return result;
	}
	private void subHelper(List<List<Integer>> result, int[] nums, List<Integer> tmp, int start){
		result.add(new ArrayList<Integer>(tmp));
		for(int i=start; i<nums.length;i++){
			tmp.add(nums[i]);
			subHelper(result, nums, tmp, i+1);
			tmp.remove(tmp.size()-1);
		}
	}
	//old code
	public List<List<Integer>> subsets_old(int[] nums) {
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

	//79. Word Search
	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(board[i][j] == word.charAt(0)){
					if(searchMap(board, word, i, j, 0, visited)){
						return true;
					}
				}
			}
		}
		return false;
    }
	private boolean searchMap(char[][] board, String word, int i, int j, int index, boolean[][] visited){
		if(index==word.length()){
			return true;
		}
		//out of boarder
		if(i>=board.length||j>=board[0].length||i<0||j<0){
			return false;
		}
		//not satisfy condition
		if(board[i][j] != word.charAt(index) || visited[i][j]){
			return false;
		}

		visited[i][j] = true;
		if(searchMap(board, word, i+1, j, index+1, visited)||
				searchMap(board, word, i-1, j, index+1, visited)||
				searchMap(board, word, i, j+1, index+1, visited)||
				searchMap(board, word, i, j-1, index+1, visited)){
			return true;
		}else{
			visited[i][j] = false;
			return false;
		}
	}
	//80. Remove Duplicates from Sorted Array II
	public int removeDuplicates2(int[] nums) {
		if(nums.length<2){
			return nums.length;
		}
		int prev = nums[0];
		int prev2 = nums[1];
		int pIdx = 2;
		for(int i=2; i <nums.length; i++){
			if(nums[i]!=prev2){
				prev = prev2;
				prev2 = nums[i];
				nums[pIdx] = nums[i];
				pIdx++;
			}else{
				if(prev!=prev2){
					prev = prev2;
					prev2 = nums[i];
					nums[pIdx] = nums[i];
					pIdx++;
				}
			}
		}
		return pIdx++;
	}
	//81. Search in Rotated Sorted Array II
	public boolean search_d(int[] nums, int target) {
		int start = 0;
		int end = nums.length -1;
		while(start<=end){
			int mid = (start+end) / 2;
			if(nums[mid]==target){
				return true;
			}else if(nums[start]==nums[mid]&&nums[mid]==nums[end]){
				start++;
				end--;
			}else if(target > nums[mid]){
				if(nums[start]>nums[mid]&&target>=nums[start]){
					end = mid - 1;
				}else{
					start = mid+1;
				}
			}else{
				if(nums[mid]>nums[end]&&target<=nums[end]){
					start = mid+1;
				}else{
					end = mid - 1;
				}
			}
		}
		return false;
    }
	//33. Search in Rotated Sorted Array
	public int search(int[] nums, int target) {
    	int start = 0;
		int end = nums.length -1;
		while(start<=end){
			int mid = (start+end) / 2;
			if(nums[mid]==target){
				return mid;
			}else if(target > nums[mid]){
				if(nums[start]>nums[mid]&&target>=nums[start]){
					end = mid - 1;
				}else{
					start = mid+1;
				}
			}else{
				if(nums[mid]>nums[end]&&target<=nums[end]){
					start = mid+1;
				}else{
					end = mid - 1;
				}
			}
		}
        return -1;
    }
	//120. Triangle
	public int minimumTotal(List<List<Integer>> triangle) {
		int lowest = triangle.size();
		int[] dp = new int[triangle.get(lowest-1).size()];
		for(int i=0; i<triangle.get(lowest-1).size(); i++){
			dp[i] = triangle.get(lowest-1).get(i);
		}
		for(int i=triangle.size()-2; i>=0; i--){
			for(int j=0; j<triangle.get(i).size(); j++){
				dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
			}
		}
		return dp[0];
	}
	//152. Maximum Product Subarray
	public int maxProduct(int[] nums) {
		int[] dpMax = new int[nums.length];
		int[] dpMin = new int[nums.length];
		int answer = dpMax[0] = dpMin[0] = nums[0];
		for(int i=1; i<nums.length; i++){
			dpMax[i] = Math.max(Math.max(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]), nums[i]);
			dpMin[i] = Math.min(Math.min(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]), nums[i]);
			answer = Math.max(dpMax[i], answer);
		}
		return answer;
    }
	//162. Find Peak Element
	public int findPeakElement(int[] nums) {
		int prev = Integer.MIN_VALUE;
		int post = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++){
			if (i-1 <0){
				prev = Integer.MIN_VALUE;
			}else{
				prev = nums[i-1];
			}
			if(i+1==nums.length){
				post = Integer.MIN_VALUE;
			}else{
				post = nums[i+1];
			}
			if(nums[i]>post&&nums[i]>prev){
				return i;
			}
		}
		return 0;
    }
	public int findPeakElementLog(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(mid==start||mid==end){
				return nums[start]>nums[end]?start:end;
			}
			if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
				return mid;
			}else if(nums[mid]>nums[mid+1]){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		return -1;
    }
	//167. Two Sum II - Input array is sorted
	public int[] twoSum_167(int[] numbers, int target) {
		int start = 0;
		int end = numbers.length-1;
		while(start<end){
			if(numbers[start]+numbers[end]==target){
				return new int[]{start+1, end+1};
			}else if(numbers[start]+numbers[end]<target){
				start++;
			}else{
				end--;
			}
		}
		return new int[]{1};
    }
	//209. Minimum Size Subarray Sum
	public int minSubArrayLen(int s, int[] nums) {
		if(nums.length==0){
			return 0;
		}
		int i = 0;
		int j = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while(i<nums.length){
			sum += nums[i++];
			while(sum>=s){
				min = Math.min(min, i-j);
				sum -= nums[j++];
			}
		}
		return (min == Integer.MAX_VALUE)? 0: min;
    }
	//216. Combination Sum III
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		bt(result, new ArrayList<Integer>(), k, n, 1);
		return result;
    }
	private void bt(List<List<Integer>> result, List<Integer> tmp, int k, int n, int start){
		if(tmp.size()==k && n==0){
			result.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=start; i<=9; i++){
			tmp.add(i);
			bt(result, tmp, k, n - i, i+1);
			tmp.remove(tmp.size()-1);
		}
	}

	public List<List<Integer>> combinationSum3TT(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		combination(ans, new ArrayList<Integer>(), k, 1, n);
		return ans;
	}

	private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
		if (comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		for (int i = start; i <= 9; i++) {
			comb.add(i);
			combination(ans, comb, k, i+1, n-i);
			comb.remove(comb.size() - 1);
		}
	}
	//228. Summary Ranges
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		for(int i=0; i<nums.length; i++){
			int start = nums[i];
			while(i<nums.length-1&&nums[i+1]-nums[i]==1){
				i++;
			}
			String s = "";
			if(start==nums[i]){
				s = String.valueOf(nums[i]);
			}else{
				s = String.valueOf(start)+"->"+String.valueOf(nums[i]);
			}
			result.add(s);
		}
		return result;
    }
	//229. Majority Element II
	public List<Integer> majorityElement2(int[] nums) {
		if(nums.length==0){
            return new ArrayList<Integer>();
        }
        int count1 = 0;
		int count2 = 0;
		int cad1 = 0;
		int cad2 = 0;
		for(int i=0; i<nums.length; i++){
			if(cad1==nums[i]){
				count1++;
			}else if(cad2==nums[i]){
				count2++;
			}else if(count1==0){
				cad1 = nums[i];
				count1 = 1;
			}else if(count2==0){
				cad2 = nums[i];
				count2 = 1;
			}else{
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i]==cad1){
				count1++;
			}else if(nums[i]==cad2){
				count2++;
			}
		}
		List<Integer> result = new ArrayList<>();
		if(count1>(nums.length/3)){
			result.add(cad1);
		}
		if(count2>(nums.length/3)){
			result.add(cad2);
		}
		return result;
	}
	//238. Product of Array Except Self
	public int[] productExceptSelf(int[] nums) {
		Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> m2 = new HashMap<Integer, Integer>();
		int product = 1;
		for(int i=0; i<nums.length; i++){
			product *= nums[i];
			m1.put(i, product);
		}
		product = 1;
		for(int i=nums.length-1; i>=0; i--){
			product *= nums[i];
			m2.put(i, product);
		}

		int[] result = new int[nums.length];
		for(int i=0; i<nums.length; i++){
			Integer left = m1.get(i-1);
			Integer right = m2.get(i+1);
			if(left==null){
				result[i] = right;
			}else if(right==null){
				result[i] = left;
			}else{
				result[i] = right*left;
			}
		}
		return result;
    }

	public int[] productExceptSelf_s1(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0, tmp = 1; i < nums.length; i++) {
			result[i] = tmp;
			tmp *= nums[i];
		}
		for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
			result[i] *= tmp;
			tmp *= nums[i];
		}
		return result;
	}
	//215. Kth Largest Element in an Array
	public int findKthLargest(int[] nums, int k) {
		k = nums.length - k;
		System.out.println(k);
		int start = 0;
		int end = nums.length-1;
		while(start<end){
			int pivot = getPivot(nums, start, end);
			if(pivot==k){
				return nums[pivot];
			}else if(pivot>k){
				end = pivot-1;
			}else{
				start = pivot+1;
			}
		}
		return nums[end]; //or start, whether it start or end, at this place, start  = end
    }
	private int getPivot(int[] nums, int start, int end){
		int p = nums[end];
		int lessIdx = start;
		for(int i=start; i<end; i++){
			if(nums[i]<=p){
				swap(nums, lessIdx++, i);
			}
		}
		swap(nums, lessIdx, end); // move pivot to it's right place
		return lessIdx;
	}
	private void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public int findPair(int[] arr, int target){
		int start = 0;
		int end = arr.length-1;
		int result = 0;
		while(start< end){
			if(arr[start]+arr[end]<target){
				result += (end-start);
				start++;
			}else{
				end--;
			}
		}
		return result;
	}

    public List<Integer> findUniqWindow(int[] arr, int k){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            Map<Integer, Integer> table = new HashMap<>();
            for(int j=0; j<k&&j+i<arr.length; j++){
                Integer c = table.get(arr[j+i]);
                if(c==null){
                    table.put(arr[j+i], 1);
                }else{
                    table.put(arr[j+i], c++);
                }
            }
            if(i==arr.length-k+1){
                break;
            }
            result.add(table.keySet().size());
        }
        return result;
    }
    //77. Combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        comb(result, new ArrayList<Integer>(), n, k, 1);
        return result;
    }
    private void comb(List<List<Integer>> result, List<Integer> tmp, int n, int k, int start){
        if(k==0){
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=start, max=n-k+1; i<=max; i++){
            tmp.add(i);
            comb(result, tmp, n, k-1, start);
            tmp.remove(tmp.size()-1);
        }
    }

}
