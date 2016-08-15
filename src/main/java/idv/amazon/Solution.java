package idv.amazon;

import java.util.*;

public class Solution{
    public void hello(){
        System.out.println("Hellow");
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
                    System.out.println(k);
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

}
