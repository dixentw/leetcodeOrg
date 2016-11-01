package idv.myleetcode.tree;

import java.util.*;

public class BSTIterator{
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        while(cur!=null){
            cur = cur.right;
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return node.val;
    }
}
