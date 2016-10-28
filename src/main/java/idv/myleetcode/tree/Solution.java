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
                tmp = tmp.right;
            }
        }
    }
    /*
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
    }*/
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
    //101. Symmetric Tree
    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }else if(left!=null&&right!=null){
            return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left) && left.val==right.val;
        }else{
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }else{
            return isSymmetricHelp(root.left, root.right);
        }
    }
    //102. Binary Tree Level Order Traversal
    private void levelOrderHelper(TreeNode node, int level, List<List<Integer>> result){
        if(node==null){
            return;
        }
        if(level>result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level-1).add(node.val);
        levelOrderHelper(node.left, level+1, result);
        levelOrderHelper(node.right, level+1, result);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderHelper(root, 1, result);
        return result;
    }
    //107. Binary Tree Level Order Traversal II
    private void levelOrderHelper2(TreeNode node, int level, List<List<Integer>> result){
        if(node==null){
            return;
        }
        if(level>result.size()){
            result.add(0, new ArrayList<Integer>());
        }
        int len = result.size();
        result.get(len - level).add(node.val);
        levelOrderHelper2(node.left, level+1, result);
        levelOrderHelper2(node.right, level+1, result);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderHelper2(root, 1, result);
        return result;
    }
    //257. Binary Tree Paths
    private void getPath(TreeNode node, String path, List<String> paths){
        if(node == null){
            return;
        }
        if(node.left==null&&node.right==null){
            paths.add(path+String.valueOf(node.val));
        }
        if(node.left!=null){
            getPath(node.left, path+node.val+"->", paths);
        }
        if(node.right!=null){
            getPath(node.right, path+node.val+"->", paths);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        getPath(root, "", result);
        return result;
    }
    //404. Sum of Left Leaves
    private void leftLeave(TreeNode node, boolean isLeft, List<Integer> rs){
        if(node.right==null&&node.left==null&&isLeft){ // hit left leaves
            rs.add(node.val);
        }
        if(node.left!=null){
            leftLeave(node.left, true, rs);
        }
        if(node.right!=null){
            leftLeave(node.right, false, rs);
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<Integer> rs = new ArrayList<Integer>();
        if(root.left!=null){
            leftLeave(root.left, true, rs);
        }
        if(root.right!=null){
            leftLeave(root.right, false, rs);
        }
        int sum = 0;
        for(Integer i : rs){
            sum += i;
        }
        return sum;
    }
    //437. Path Sum III
    private int goPath(TreeNode node, int sum){
        int result = 0;
        if(node==null){
            return result;
        }
        if(sum==node.val){
            result++;
        }
        result += goPath(node.left, sum-node.val);
        result += goPath(node.right, sum-node.val);
        return result;
    }
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        return goPath(root,sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    //110. Balanced Binary Tree
    public boolean isBalanced(TreeNode root) {
        if(root ==null){
            return true;
        }
        return depth(root)!=-1;
    }
    private int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left, right)+1;
    }
    //144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root!=null){
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }
    //145. Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root!=null){
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
    }
    //96. Unique Binary Search Trees
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
    //95. Unique Binary Search Trees II
    // this is dynamic programming method
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        if(n==0){
            return result[0];
        }
        result[0].add(null);
        for(int i=1; i<=n; i++){
            result[i] = new ArrayList<TreeNode>();
            for(int j=1; j<=i; j++){
                for(TreeNode nodeL : result[j-1]){
                    for(TreeNode nodeR : result[i-j]){
                        TreeNode root = new TreeNode(j);
                        root.left = nodeL;
                        root.right = clone(nodeR, j);
                        result[i].add(root);
                    }
                }
            }
        }
        return result[n];
    }
    private TreeNode clone(TreeNode n, int offset){
        if(n==null){
            return null;
        }
        TreeNode node = new TreeNode(n.val+offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
    // this is divied and conquire method
    public List<TreeNode> generateTrees2(int n){
        if(n<=0){
            return new ArrayList<TreeNode>();
        }else{
            return generateSubTree(1, n);
        }
    }
    private List<TreeNode> generateSubTree(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(end<start){ //why?
            res.add(null);
            return res;
        }
        for(int i=start; i<=end; i++){
            for(TreeNode l : generateSubTree(start, i-1)){
                for(TreeNode r : generateSubTree(i+1, end)){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
    //98. Validate Binary Search Tree
    // to inorder method
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inorder(root, inOrder);
        for(int i=1; i<inOrder.size(); i++){
            if(inOrder.get(i-1) >= inOrder.get(i)){
                return false;
            }
        }
        return true;
    }
    private void inorder(TreeNode root, List<Integer> rs){
        if(root==null){
            return;
        }
        inorder(root.left, rs);
        rs.add(root.val);
        inorder(root.right, rs);
    }
    public boolean isValidBST_1(TreeNode root) {
        return validBSTHelper(root, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    private boolean validBSTHelper(TreeNode node, int min, int max){
        if(node==null){
            return true;
        }else if(node.left==null&&node.right==null){
            return node.val > min && node.val < max;
        }else if(node.left!=null){
            return validBSTHelper(node.left, min, node.val);
        }else if(node.right!=null){
            return validBSTHelper(node.right, node.val, max);
        }else{
            return validBSTHelper(node.left, min, node.val) && validBSTHelper(node.right, node.val, max);
        }

    }
    //105. Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pstart =0;
        int pend = preorder.length-1;
        int istart = 0;
        int iend = inorder.length-1;
        return constructTree(preorder, inorder, pstart, pend, istart, iend);

    }
    private TreeNode constructTree(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend){
        if(pstart>pend || istart>iend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int i=istart;
        for(i=istart; i<=iend; i++){
            if(inorder[i]==preorder[pstart]){
                break;
            }
        }
        root.left = constructTree(preorder, inorder, pstart+1, pstart+i-istart, istart, i-1);
        root.right = constructTree(preorder, inorder, pstart+i-istart+1, pend, i+1, iend);
        return root;
    }
    //106. Construct Binary Tree from Inorder and Postorder Traversal
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int istart = 0;
        int iend = inorder.length-1;
        int pstart =0;
        int pend = postorder.length-1;
        return constructTree2(inorder, postorder, istart, iend, pstart, pend);
    }
    private TreeNode constructTree2(int[] inorder, int[] postorder, int istart, int iend, int pstart, int pend){
        if(pstart>pend || istart>iend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pend]);
        int i=istart;
        for(i=istart; i<=iend; i++){
            if(inorder[i]==postorder[pend]){
                break;
            }
        }
        root.left = constructTree2(inorder, postorder, istart, i-1, pstart, pstart+(i-istart)-1);
        root.right = constructTree2(inorder, postorder, i+1, iend, pstart+(i-istart), pend-1);
        return root;
    }
}
