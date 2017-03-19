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
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(target < nums[mid]){
                end = mid-1;
            }else if(target > nums[mid]){
                start = mid+1;
            }else{ // hit
                int low = mid;
                int high = mid;
                while(low>=0&&nums[low]==nums[mid]){
                    low--;
                }
                while(high<nums.length&&nums[high]==nums[mid]){
                    high++;
                }
                return new int[]{low+1, high-1};
            }
        }
        return new int[]{-1, -1};
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
        while(currentMax-i+1>0){
            level++;
            for(;i<=currentMax; i++){
                System.out.println("fff");
                nextMax = Math.max(nextMax, nums[i]+i);
                if(nextMax>=nums.length-1){
                    return level;
                }
            }
            currentMax = nextMax;
        }
        return 0;
    }

}
