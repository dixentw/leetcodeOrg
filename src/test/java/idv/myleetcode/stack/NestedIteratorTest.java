package idv.myleetcode.stack;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class NestedIteratorTest{

    @Test
    public void test1(){
        NestedInteger test = NestedInteger.deserialize("[123,[456,[789]]]");
        NestedIterator ni = new NestedIterator(test);
        int[] re = new int[3];
        int i=0;
        while(ni.hasNext()){
            re[i++] = ni.next();
        }
        assertEquals(Arrays.toString(new int[]{123, 456,789}), Arrays.toString(re));
    }
}
