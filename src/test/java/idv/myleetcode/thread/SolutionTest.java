package idv.myleetcode.thread;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {

    @Test
    public void testMultiThread(){
        try{
            Solution.go();
        }catch(Exception e){
            System.out.println("exception");
        }

    }
}
