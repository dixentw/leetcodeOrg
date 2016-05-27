package idv.myleetcode.algo;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {

    @Test
    public void testA(){
        ArrayList<ArrayList<Integer>> adjLists = new ArrayList<ArrayList<Integer>>();
        final int n = 7;

        // Add an empty adjacency list for each vertex
        for(int v=0; v<n; v++){
            adjLists.add(new ArrayList<Integer>());
        }

        // insert neighbors of vertex 0 into adjacency list for vertex 0
        adjLists.get(0).add(1);
        adjLists.get(0).add(2);
        adjLists.get(0).add(3);

        // insert neighbors of vertex 1 into adjacency list for vertex 1
        adjLists.get(1).add(5);
        adjLists.get(1).add(6);

        // insert neighbors of vertex 2 into adjacency list for vertex 2
        adjLists.get(2).add(4);

        // insert neighbors of vertex 3 into adjacency list for vertex 3
        adjLists.get(3).add(2);
        adjLists.get(3).add(4);

        // insert neighbors of vertex 4 into adjacency list for vertex 4
        adjLists.get(4).add(1);

        // insert neighbors of vertex 5 into adjacency list for vertex 5
        // -> nothing to do since vertex 5 has no neighbors

        // insert neighbors of vertex 6 into adjacency list for vertex 5
        adjLists.get(6).add(4);

        // Print vertices in the order in which they are visited by dfs()
        Solution s = new Solution(n);
        s.ddfs(adjLists, 0);
    }
}
