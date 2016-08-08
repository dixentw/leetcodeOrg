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
}
