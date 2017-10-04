package idv.amazon;

import java.util.*;

public class Solution{
	private List<String> getDirectFriendsForUser(String u){
		return new ArrayList<String>();
	}
	private List<String> getAttendedCoursesForUser(String u){
		return new ArrayList<String>();
	}
	public List<String> getRankedCourses(String user) {
		List<String> friends = getDirectFriendsForUser(user);
		List<String> attended = getAttendedCoursesForUser(user);
		Map<String, Integer> coursesFromFriends = new HashMap<>();
		List<String> result = new ArrayList<>();
			for(String friend : friends){
				List<String> courses = getAttendedCoursesForUser(friend);
				for(String cid : courses){
					Integer count = coursesFromFriends.get(cid);
					if(count==null){
						count = new Integer(1);
					}else{
						count++;
					}
					coursesFromFriends.put(cid, count);
				}
			}
			//remove attended courses from courses from friends
			Iterator<String> itr = coursesFromFriends.keySet().iterator();
			List<String> removeKeys = new ArrayList<>();
			while(itr.hasNext()){
				String cid = itr.next();
				if(attended.contains(cid)){
					removeKeys.add(cid);
				}
			}

			for(String id :removeKeys ){
				coursesFromFriends.remove(id);
			}

			// sort by values
			List<Map.Entry<String, Integer>> list = new LinkedList<>(coursesFromFriends.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
					public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
						return (o2.getValue()).compareTo(o1.getValue());
					}
				});
			for(Map.Entry<String, Integer> e : list){
				result.add(e.getKey());
			}
		return result;

	}
	public int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
		int[][] result = new int[cityWidth][cityLength];
		int[][] point = new int[lockerXCoordinates.length][2];
		for(int i=0; i<lockerXCoordinates.length;i++){
			point[i][0] = lockerYCoordinates[i] - 1;
			point[i][1] = lockerXCoordinates[i] - 1;
		}
		for(int i=0; i<cityWidth; i++){
			for(int j=0; j<cityLength; j++){
				int minDistance = Integer.MAX_VALUE;
				for(int k=0; k<lockerXCoordinates.length;k++){
					int distance = Math.abs(i - point[k][0]) + Math.abs(j - point[k][1]);
					if(distance < minDistance){
						minDistance = distance;
					}
				}
				result[i][j] = minDistance;
			}
		}
		return result;
	}
	public int maxIsland(int[][] map){
		int mapSize = map.length;
		int max = 0;
		for(int i=0; i<mapSize; i++){
			for(int j=0; j<mapSize; j++){
				if(map[i][j]==1){
					List<Integer> counter = new ArrayList<>();
					markaround(map, i, j, counter);
					if(max < counter.size()){
						max = counter.size();
					}
				}
			}
		}
		return max;
	}
	private void markaround(int[][] map, int i, int j, List<Integer> iSize){
		if(i<0||j<0||i>=map.length||j>=map.length||map[i][j]==0){
			return;
		}
		iSize.add(1);
		map[i][j] = 0;
		markaround(map, i+1, j, iSize);
		markaround(map, i, j+1, iSize);
		markaround(map, i-1, j, iSize);
		markaround(map, i, j-1, iSize);
	}

	public int getExitGrid(int[][] grid, int gridRow, int gridCol, int exitRow, int exitCol) {
		for(int i=0; i<gridRow; i++){
			for(int j=0; j<gridCol; j++){
				if(grid[i][j]==1){
					grid[i][j] = Integer.MIN_VALUE;
				}
			}
		}
		goGrid(grid, gridRow, gridCol, 0, 0, 0);
		return grid[exitRow][exitCol];
	}
	private void goGrid(int[][] grid, int gridRow, int gridCol, int i, int j, int prev){
		if(i<0||j<0||i>=gridRow||j>=gridCol||grid[i][j]==Integer.MIN_VALUE){
			return;
		}
		if(grid[i][j]!=0 && grid[i][j] < prev){
			return;
		}
		grid[i][j] = prev;
		prev++;
		goGrid(grid, gridRow, gridCol, i+1, j, prev);
		goGrid(grid, gridRow, gridCol, i, j+1, prev);
		goGrid(grid, gridRow, gridCol, i-1, j, prev);
		goGrid(grid, gridRow, gridCol, i, j-1, prev);
	}

	public void testTreeSet(){
		TreeMap<Float, String> treeMap = new TreeMap<>(new Comparator<Float>(){
			@Override
			public int compare(Float f1, Float f2){
				return -1 * f1.compareTo(f2);
			}
		});

		treeMap.put(new Float(1.4), "fwefwee1");
		treeMap.put(new Float(3.4),"fwefwee2");
		treeMap.put(new Float(4.4),"fwefwee3");

		for(Map.Entry<Float, String> e : treeMap.entrySet()){
			System.out.println(e.getValue());
		}
	}

	public List<List<String>> getAllSubString(String s) {
        List<List<String>> result = new ArrayList<>();
        find(result, new ArrayList<String>(), s, 0);
        return result;
    }
    private void find(List<List<String>> result, List<String> tmp, String s, int start){
		if(start==s.length()){
			result.add(new ArrayList<String>(tmp));
		}
        for(int i=start; i<s.length();i++){
            String sub = s.substring(start, i+1);
			tmp.add(sub);
			find(result, tmp, s, i+1);
			tmp.remove(tmp.size()-1);
        }
    }

	public int findNumberOfIsland(int[][] map){
		int result = 0;
		int len = map.length;
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				if(map[i][j]==1){
					result++;
					tra(map, i, j);
				}
			}
		}
		return result;
	}
	private void tra(int[][] map, int x, int y){
		if(x<0||x>=map.length||y<0||y>=map.length){
			return;
		}
		if(map[x][y]==0){
			return;
		}
		if(map[x][y]==1){
			map[x][y]=0;
		}
		tra(map, x-1, y);
		tra(map, x, y-1);
		tra(map, x+1, y);
		tra(map, x, y+1);
		tra(map, x-1, y-1);
		tra(map, x-1, y+1);
		tra(map, x+1, y-1);
		tra(map, x+1, y+1);
	}
	// Count inversion
	public int countInvertion(int[] nums){
		return mergeSort(nums, 0, nums.length-1);
	}
	public int mergeSort(int[] nums, int start, int end){
		if(start==end){
			return 0;
		}else if(end-start==1){
			if(nums[start]> nums[end]){
				int tmp = nums[start];
				nums[start] = nums[end];
				nums[end] = tmp;
				return 1;
			}
		}else{
			int mid = (start+end)/2;
			int il = mergeSort(nums, start, mid);
			int ir = mergeSort(nums, mid+1, end);
			int mm = mergeHelper(nums, start, mid, end);
			return il+ir+mm;
		}
		return 0;
	}
	private int mergeHelper(int[] nums, int start, int mid, int end){
		int i = start;
		int j = mid+1;
		int[] tmp = new int[end-start+1];
		int c = 0;
		for(int k=0; k<tmp.length;k++){
			if(i>mid){
				tmp[k] = nums[j++];
			}else if(j>end){
				tmp[k] = nums[i++];
			}else if(nums[i]> nums[j]){
				tmp[k] = nums[j++];
				c += (mid - i+1);
			}else{
				tmp[k] = nums[i++];
			}
		}
		for(i=0; i<tmp.length; i++){
			nums[start+i] = tmp[i];
		}
		return c;
	}
	public int checkWinner(List<List<String>> codeList, List<String> shoppingCart){
		int codeIndex = 0;
		int groupIndex = 0;
		for(String fruit : shoppingCart){
			//System.out.println(codeIndex + ";   "+groupIndex);
			String m = codeList.get(codeIndex).get(groupIndex);
			if(fruit.equals(m)||m=="anything"){
				groupIndex++;
				if(groupIndex==codeList.get(codeIndex).size()){
					codeIndex++;
					groupIndex = 0;
				}
				if(codeIndex==codeList.size()){
					return 1;
				}
			}else{
				if(groupIndex!=0){ // if not match, won't win
					return 0;
				}
			}
		}
		return 0;
	}
	class FieldTree {
		int height;
		int x;
		int y;
	}
	public int levelFieldTime(int numRows, int numColumns, List<List<Integer>> field){
		List<FieldTree> trees = new ArrayList<>();
		for(int i=0; i<numRows; i++){
			for(int j=0; j<numColumns; j++){
				if(field.get(i).get(j)>1){
					FieldTree ft = new FieldTree();
					ft.height = field.get(i).get(j);
					ft.x = i;
					ft.y = j;
					trees.add(ft);
				}
			}
		}
		Collections.sort(trees, new Comparator<FieldTree>(){
			public int compare(FieldTree t1, FieldTree t2){
				return t1.height - t2.height;
			}
		});
		int[] DP = new int[trees.size()];
		FieldTree start = new FieldTree();
		start.x = 0;
		start.y = 0;
		for(int i=0; i<DP.length; i++){
			if(i==0){
				DP[i] = findMinPath(numRows, numColumns, start, trees.get(i), field);
			}else{
				int init = 0;
				while(trees.get(init).height<trees.get(i).height){
					init++;
				}
				int minValue = Integer.MAX_VALUE;
				for(int j=init--; j<i; j++){
					int tmp = findMinPath(numRows, numColumns, trees.get(j), trees.get(i), field);
					if(tmp < minValue){
						minValue = tmp;
					}
				}
				DP[i] = minValue;
			}
		}
		return DP[DP.length-1];
	}
	public int findMinPath(int row, int col, FieldTree t1, FieldTree t2, List<List<Integer>> field){
		if(t2==null){
			return Integer.MAX_VALUE;
		}
		if(t1.x==t2.x&&t1.y==t2.y){
			return 0;
		}
		int x = t2.x;
		int y = t2.y;
		System.out.println(t2.x+","+t2.y);
		FieldTree left = null;
		FieldTree right = null;
		FieldTree top = null;
		FieldTree down = null;
		if(x-1>=0&&field.get(x-1).get(y)!=0&&field.get(x-1).get(y)<=field.get(x).get(y)){
			top = new FieldTree();
			top.x = t2.x-1;
			top.y = t2.y;
		}
		if(x+1<row&&field.get(x+1).get(y)!=0&&field.get(x+1).get(y)<=field.get(x).get(y)){
			down = new FieldTree();
			down.x = t2.x+1;
			down.y = t2.y;
		}
		if(y-1>=0&&field.get(x).get(y-1)!=0&&field.get(x).get(y-1)<=field.get(x).get(y)){
			left = new FieldTree();
			left.x = t2.x;
			left.y = t2.y-1;
		}
		if(y+1<col&&field.get(x).get(y+1)!=0&&field.get(x).get(y+1)<=field.get(x).get(y)){
			right = new FieldTree();
			right.x = t2.x;
			right.y = t2.y+1;
		}
		int minPath1 = Math.min(findMinPath(row, col, t1, left, field), findMinPath(row, col, t1, right, field));
		int minPath2 = Math.min(findMinPath(row, col, t1, top, field), findMinPath(row, col, t1, down, field));
		return Math.min(minPath1, minPath2)+1+field.get(t2.x).get(t2.y);
	}
}
