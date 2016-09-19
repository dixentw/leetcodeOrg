package idv.myleetcode.algo;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


public class BackTrackTest {
    private BackTrack bt = new BackTrack();
    @Test
    public void test2(){
        bt.strperm("abc");
    }
    @Test
    public void test3(){
        List<String> result = bt.strperm2("aba");
        System.out.println("----------------");
        for(String s : result){
            System.out.println(s);
        }
    }
    @Test
    public void test4(){
        List<String> result = bt.strpermUnique("aa");
        System.out.println("----------------");
        for(String s : result){
            System.out.println(s);
        }
    }

}
