package idv.myleetcode.thread;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class ConProTest {

    @Test
    public void testMultiThread(){
        ConProExp cpe = new ConProExp();
        try{
            cpe.go();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
