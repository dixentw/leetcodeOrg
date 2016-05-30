package idv.myleetcode.algo;

import java.util.*;
/**
 * Hello world!
 */
public class FloodFill{
    class Point{
        int x;
        int y;
        public Point(int i, int j){
            x = i;
            y = j;
        }
    }
    Stack<Point> stack = new Stack<>();
    public void fill(int[][] A, int X, int Y, int srcColor, int tgtColor){
        if(A[X][Y] != srcColor || A[X][Y] == tgtColor){
            return;
        }
        A[X][Y] = tgtColor;
        for(int i=X-1; i<=X+1; i++){
            for(int j=Y-1; j<=Y+1; j++){
                if(i==X && j==Y){
                    continue;
                }
                if(i>=0&&i<A.length&&j>=0&&j<A[i].length){
                    fill(A, i, j, srcColor, tgtColor);
                }
            }
        }
    }
    public void fillStack(int[][] A, int X, int Y, int srcColor, int tgtColor){
        stack.push(new Point(X, Y));
        while(!stack.empty()){
            Point p = stack.pop();
            if(A[p.x][p.y] != srcColor || A[p.x][p.y] == tgtColor){
                continue;
            }
            A[p.x][p.y] = tgtColor;
            for(int i=p.x-1; i<=p.x+1; i++){
                for(int j=p.y-1; j<=p.y+1; j++){
                    if(i==p.x&&j==p.y){
                        continue;
                    }
                    if(i>=0 && i<A.length &&j>=0 && j<A[i].length){
                        stack.push(new Point(i, j));
                    }
                }
            }
        }
    }
}
