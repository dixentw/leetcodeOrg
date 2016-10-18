package idv.myleetcode.stack;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class NestedIteratorTest{

    @Test
    public void test1(){
        NestedInteger n1 = new NestedInteger(1,1);
        NestedInteger n2 = new NestedInteger(2);
        NestedInteger n3 = new NestedInteger(1,1);
        List<NestedInteger> test = new ArrayList<>();
        test.add(n1);
        test.add(n2);
        test.add(n3);

        NestedIterator ni = new NestedIterator(test);
        int[] re = new int[5];
        int i=0;
        while(ni.hasNext()){
            re[i++] = ni.next();
        }
        assertEquals(Arrays.toString(new int[]{1,1,2,1,1}), Arrays.toString(re));
    }
}
