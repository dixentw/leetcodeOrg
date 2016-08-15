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
}
