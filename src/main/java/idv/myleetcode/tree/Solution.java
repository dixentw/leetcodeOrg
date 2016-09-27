package idv.myleetcode.tree;

import java.util.*;
/**
 * Hello world!
 */
public class Solution{
    //226. invert tree
    public TreeNode invertTree(TreeNode root){
        if(root!=null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if(root.left!=null){
                invertTree(root.left);
            }
            if(root.right!=null){
                invertTree(root.right);
            }
        }
        return root;
    }
    //235, 236. LCA
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        // hit requirement, return p or q
        if(root == p || root == q){
            return root;
        }
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        if(leftLCA!=null && rightLCA !=null){
            return root;
        }else{
            if(leftLCA!=null){
                return leftLCA;
            }else{
                return rightLCA;
            }
        }
    }
    // 111. Tree Min depth
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        if(root.right==null||root.left==null){
            return 1 + Math.max(minDepth(root.right), minDepth(root.left));
        }
        return 1+ Math.min(minDepth(root.left), minDepth(root.right));
    }
    // 112. Path Sum
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.right==null&&root.left==null){
            if(sum == root.val){
                return true;
            }else{
                return false;
            }
        }
        sum = sum - root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
    // 100 Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null && q!=null){
            if(p.val!=q.val){
                return false;
            }else{
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }else if(p==null&&q==null){
            return true;
        }else{
            return false;
        }
    }
    // 94 binary tree inorder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
    //104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        if(root.right==null||root.left==null){
            return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
        }
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    // traversal
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        stack.push(tmp);
        while(!stack.empty()){
            TreeNode n = stack.pop();
            System.out.println(n.val);
            if(n.right!=null){
                stack.push(n.right);
            }
            if(n.left!=null){
                stack.push(n.left);
            }
        }
    }
    public void inOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while(!stack.empty() || tmp!=null){
            if(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }else{
                tmp = stack.pop();
                System.out.println(tmp.val);
                tmp = tmp.right;
            }
        }
    }
    public TreeNode constructTree(int[] pre, int[] in){
        int preStart = 0;
        int preEnd = pre.length-1;
        int inStart = 0;
        int inEnd = in.length-1;
        return construct(pre, preStart, preEnd, in, inStart, inEnd);
    }
    public TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie){
        if(ps>pe||is>ie){
            return null;
        }
        TreeNode p = new TreeNode(pre[ps]);
        int k = 0;
        for(int i=0; i<in.length; i++){
            if(pre[ps]==in[i]){
                k=i;
                break;
            }
        }
        p.left = construct(pre, ps+1, ps+(k-is), in, is, k-1);
        p.right=construct(pre, ps+(k-is)+1, pe, in, k+1, ie);
        return p;
    }
    // 103. Binary Tree Zigzag Level Order Traversal
    private void traverseZigzag(TreeNode node, int level, List<List<Integer>> result){
        if(node==null){
            return;
        }
        if(level > result.size()){
            result.add(new ArrayList<Integer>());
        }
        if(level%2!=0){ // left to rigth
            result.get(level-1).add(node.val);
        }else{
            result.get(level-1).add(0, node.val);
        }
        traverseZigzag(node.left, level+1, result);
        traverseZigzag(node.right, level+1, result);
    }
    public List<List<Integer>> zigzagLevelOrder0(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverseZigzag(root, 1, result);
        return result;
    }
    /*
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Vector<TreeNode> queue = new Vector<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.removeElementAt(0);
            if(node.left!=null){

            }
        }
        return null;
    }*/
}
