package idv.myleetcode.algo;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    private Solution s = new Solution();

    @Test
    public void testAddDigit(){
        //System.out.println(s.addDigit(1990));
    }

    @Test
    public void testBinarySearch(){
        int n = s.firstBadVersion(2);
        //System.out.println("fffffff : " +n);
    }

    @Test
    public void testMultiThread(){
        try{
            assertEquals(18, s.computeArea(0,0,3,3,3,0,6,3));
            assertEquals(28, s.computeArea(0,0,4,4,3,0,7,4));
            assertEquals(4, s.computeArea(0,0,0,0,-1,-1,1,1));
            assertEquals(17, s.computeArea(-2,-2,2,2,3,3,4,4));
            assertEquals(17, s.computeArea(-2,-2,2,2,-4,-4,-3,-3));
            assertEquals(19, s.computeArea(-2,-2,2,2,1,-3,3,-1));
        }catch(Exception e){
            System.out.println("exception");
        }
    }
    @Test
    public void testNumOfIsland(){
        /*
        int[][] data = new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,0,0,0,0},
            {0,0,1,0,0,1,1,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,1,0,0,0,0,0},
            {0,0,1,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
        };
        assertEquals(4, s.numberOfIsland(data));
        */
        char[][] ddd = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals(1, s.numberOfIsland(ddd));
    }
    @Test
    public void testStairCase(){
        s.stairCase(6);
    }
    @Test
    public void testInversion(){
        assertEquals(5, s.countInversion(new int[]{1, 20, 6, 4, 5}));
    }
    @Test
    public void testInversionString(){
        String str = "this is a dog";
        assertEquals("siht si a god", s.reverseSentence(str));
        assertEquals("   ", s.reverseSentence("   "));
        assertEquals(" oS ynam  sraey ", s.reverseSentence(" So many  years "));
    }
    @Test
    public void testCalPossibleMove(){
        assertEquals("1", intarray(s.goBoard(1)));
        assertEquals("2", intarray(s.goBoard(2)));
        assertEquals("4", intarray(s.goBoard(3)));
        assertEquals("8", intarray(s.goBoard(4)));
        assertEquals("16", intarray(s.goBoard(5)));
        assertEquals("500", intarray(s.goBoard(10)));
        assertEquals("294920231533022143433974685214", intarray(s.goBoard(100)));
        assertEquals("14769971190163199278855704582770756920881183496322837447676421349035643398204799410504286624137519256019665672950244154325878807140322890332452785519708318827413038940945020516226559", intarray(s.goBoard(610)));
    }
    @Test
    public void testAddList(){
        List<Integer> a = new LinkedList<>();
        a.add(3);
        List<Integer> b = new LinkedList<>();
        b.add(8);
        List<Integer> sum = s.addTwoList(a, b);
        assertEquals("[1, 1]", Arrays.toString(sum.toArray()));
    }
    @Test
    public void testAddList1(){
        List<Integer> a = new LinkedList<>();
        a.add(3);
        List<Integer> b = new LinkedList<>();
        b.add(6);
        List<Integer> sum = s.addTwoList(a, b);
        assertEquals("[9]", Arrays.toString(sum.toArray()));
    }
    @Test
    public void testAddList2(){
        List<Integer> a = new LinkedList<>();
        a.add(3);
        List<Integer> b = new LinkedList<>();
        b.add(7);
        List<Integer> sum = s.addTwoList(a, b);
        assertEquals("[1, 0]", Arrays.toString(sum.toArray()));
    }
    @Test
    public void testAddList3(){
        List<Integer> a = new LinkedList<>();
        a.add(8);
        List<Integer> b = new LinkedList<>();
        b.add(1);
        b.add(3);
        List<Integer> sum = s.addTwoList(a, b);
        assertEquals("[2, 1]", Arrays.toString(sum.toArray()));
    }
    private String intarray(Integer[] a){
        String result="";
        for(Integer n : a){
            result += n;
        }
        return result;
    }
    @Test
    public void testFib(){
        assertEquals(0, s.fib(0));
        assertEquals(1, s.fib(1));
        assertEquals(1, s.fib(2));
        assertEquals(2, s.fib(3));
        assertEquals(3, s.fib(4));
        assertEquals(5, s.fib(5));
        assertEquals(8, s.fib(6));
        assertEquals("[8]", Arrays.toString(s.fib2(6)));
        assertEquals("[1, 3]", Arrays.toString(s.fib2(7)));
        assertEquals("[5, 5]", Arrays.toString(s.fib2(10)));
        assertEquals("354224848179261915075", intarray(s.fib2(100)));
        /*
        assertEquals(
        "23900109071036005903424820067380330956219512493343882508838587020910576"+
        "83092672249300667732710043030096958570568120504263227222274884835969693"+
        "305391984127516096891138297557750667528444376299355566899086217470585201"+
        "709179538330766732289392858771504945263866203006212807494999249521995167"+
        "1296073643381455323195828233361965631449799582445247517464135222467799740"+
        "89762311945578541066416190310111721576542869160610433565231593348571364873"+
        "52779804235483277506977454306460042287968212874761824582897118739286429568840003151050106146828835563160817912048376040050029809912293013734791567749471727392937824065261113177259783202662957881148637632338195187490758787735996699022778723575367214258563034452504094360966531897568256418608645465915444745840473934322871426418866598642747848660145342643755366760919516317387477526541252807114293921792114970905075434450564838742451198888345673434700068960962172644679947794329807611771708249033661865248799511661306285140477533559743999464574932871122125066107105911374614630965320293086278694399936369060752395531165804412176996135810584035128447884802662630006754418904791563798389799016017336123177492245220148295507234160487497059285034564989541608419857951981398972834439558266427410836592525389894745439937417033358839088886819050208294080514041113275997534122520735761635971975621605403703050984275628628811283403426936742851082726036123336764016240562071825096262121405587203818756266733130406345518134166312225673215071500009165695469591411166981267241101113735558997083171850461315680070428706983814819412637005375477590183910679020180492817106735246177201410250973608332090435177967936901320342366183865669056306257798108871942566285065496557591483743343454453933506", intarray(s.fib2(8181)));
        */
    }
}
