package idv.myleetcode.tree;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    Solution s = new Solution();

    @Test
    public void test226(){
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;
        s.invertTree(root);

        assertEquals(3, root.left.val);
        assertEquals(2, root.right.val);
    }
    @Test
    public void test112(){
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        root.left = l;
        assertTrue(s.hasPathSum(root, 3));
    }
    @Test
    public void test113(){
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode rr = new TreeNode(5);
        TreeNode lll = new TreeNode(6);
        TreeNode rrr = new TreeNode(7);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = rr;
        r.left = lll;
        r.right = rrr;
        s.inOrder(root);
    }
    /*
    @Test
    public void test4(){
        int[] pre = new int[]{1,2,4,5,3,7,6,8};
        int[] in = new int[]{4,2,5,1,6,7,3,8};
        TreeNode root = s.constructTree(pre, in);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
    }*/
    @Test
    public void test5(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = s.zigzagLevelOrder0(root);
        List<Integer> flat = new ArrayList<>();
        for(List<Integer> l : result){
            for(Integer i : l){
                flat.add(i);
            }
        }
        assertEquals("[3, 20, 9, 15, 7]", Arrays.toString(flat.toArray()));
    }
    @Test
    public void test6(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        assertTrue(s.isSymmetric(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        assertFalse(s.isSymmetric(root));
    }
    @Test
    public void test7(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> r = s.levelOrder(root);
        List<Integer> flat = new ArrayList<>();
        for(List<Integer> l : r){
            for(Integer i : l){
                flat.add(i);
            }
        }
        assertEquals("[3, 9, 20, 15, 7]", Arrays.toString(flat.toArray()));
    }
    @Test
    public void test8(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        List<String> result = s.binaryTreePaths(root);
        assertEquals("1->2->5", result.get(0));
        assertEquals("1->3", result.get(1));
    }
    @Test
    public void test9(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        //assertEquals(24, s.sumOfLeftLeaves(root));

        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(-7);
        root.left.right = new TreeNode(-6);
        root.left.left.left = new TreeNode(-7);
        root.left.right.left = new TreeNode(-5);
        root.left.right.left.left = new TreeNode(-4);
        assertEquals(-11, s.sumOfLeftLeaves(root));
    }
    @Test
    public void test10(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        assertEquals(3, s.pathSum(root, 8));

    }
    @Test
    public void test11(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> r = s.levelOrderBottom(root);
        List<Integer> flat = new ArrayList<>();
        for(List<Integer> l : r){
            for(Integer i : l){
                flat.add(i);
            }
        }
        assertEquals("[15, 7, 9, 20, 3]", Arrays.toString(flat.toArray()));
    }
    @Test
    public void test12(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> ttt = s.preorderTraversal(root);
        assertEquals("[1, 2, 3]", Arrays.toString(ttt.toArray()));
    }
    @Test
    public void test13(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> ttt = s.postorderTraversal(root);
        assertEquals("[3, 2, 1]", Arrays.toString(ttt.toArray()));
    }
    @Test
    public void test14(){
        assertEquals(5, s.numTrees(3));
    }
    @Test
    public void test15(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertFalse(s.isValidBST_1(root));
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        assertTrue(s.isValidBST_1(root));
        root = new TreeNode(1);
        root.left = new TreeNode(1);
        assertFalse(s.isValidBST_1(root));
    }
    @Test
    public void test16(){
        int[] preorder = {1, 2, 4, 5, 3, 7, 6, 8};
        int[] inorder = {4, 2, 5, 1, 6, 7, 3, 8};
        TreeNode test = s.buildTree(preorder, inorder);
        assertEquals(1, test.val);
        assertEquals(2, test.left.val);
        assertEquals(3, test.right.val);
        assertEquals(4, test.left.left.val);
        assertEquals(5, test.left.right.val);
        assertEquals(6, test.right.left.left.val);
        assertEquals(7, test.right.left.val);
        assertEquals(8, test.right.right.val);
    }
    @Test
    public void test17(){
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        TreeNode test = s.buildTree(preorder, inorder);
        assertEquals(1, test.val);
        assertEquals(2, test.right.val);
    }
    @Test
    public void test18(){
        int[] inorder = {1, 2};
        int[] postorder = {2, 1};
        TreeNode test = s.buildTree2(inorder, postorder);
        assertEquals(1, test.val);
        assertEquals(2, test.right.val);
    }
    @Test
    public void test19(){
        int[] A = {1,2,3};
        TreeNode result = s.sortedArrayToBST(A);
        assertEquals(2, result.val);
        assertEquals(1, result.left.val);
        assertEquals(3, result.right.val);
    }
    @Test
    public void test20(){
        TreeNode tmp = new TreeNode(5);
        tmp.left = new TreeNode(4);
        tmp.right = new TreeNode(8);
        tmp.left.left = new TreeNode(11);
        tmp.left.left.left = new TreeNode(7);
        tmp.left.left.right = new TreeNode(2);
        tmp.right.left = new TreeNode(13);
        tmp.right.right = new TreeNode(4);
        tmp.right.right.left = new TreeNode(5);
        tmp.right.right.right = new TreeNode(1);
        List<List<Integer>> result =  s.pathSum2(tmp, 22);
        assertEquals("[5, 4, 11, 2]", Arrays.toString(result.get(0).toArray()));
        assertEquals("[5, 8, 4, 5]", Arrays.toString(result.get(1).toArray()));
    }
    @Test
    public void test21(){
        TreeNode tmp = new TreeNode(1);
        tmp.left = new TreeNode(2);
        tmp.right = new TreeNode(3);
        assertEquals(25, s.sumNumbers(tmp));
    }

    @Test
    public void test22(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        s.flatten_org(root);

        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.right.val);
    }
    @Test
    public void test23(){
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        s.connect(root);
        assertEquals(root.left.next, root.right);
    }
}
