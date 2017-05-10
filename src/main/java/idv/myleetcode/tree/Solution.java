package idv.myleetcode.tree;

import java.util.*;

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
    public List<Integer> inorderTraversal_s(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while(!stack.empty() || tmp!=null){
            if(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }else{
                tmp = stack.pop();
                result.add(tmp.val);
                tmp = tmp.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal_m(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                result.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre = pre.right;
                }
                if(pre.right==null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    result.add(cur.val);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
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
    public List<Integer> preorderTraversal_s(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        stack.push(tmp);
        while(!stack.empty()){
            TreeNode n = stack.pop();
            result.add(n.val);
            if(n.right!=null){
                stack.push(n.right);
            }
            if(n.left!=null){
                stack.push(n.left);
            }
        }
        return result;
    }
    public List<Integer> preorderTraversal_m(TreeNode root){
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                result.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right!=null&&pre.right!=cur){
                    pre = pre.right;
                }
                if(pre.right==null){
                    pre.right = cur;
                    result.add(cur.val);
                    cur = cur.left;
                }else{
                    pre.right = null;
                    cur = cur.right;
                }
            }
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
    public List<Integer> postorderTraversal_s(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.empty()){
            TreeNode tmp = stack1.pop();
            if(tmp.left!=null){
                stack1.push(tmp.left);
            }
            if(tmp.right!=null){
                stack1.push(tmp.right);
            }
            stack2.push(tmp);
        }
        while(!stack2.empty()){
            result.add(stack2.pop().val);
        }
        return result;
    }
    public List<Integer> postorderTraversal_s1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        stack.push(node);
        while(!stack.empty()){
            TreeNode curr = stack.peek();
            if((curr.left==null&&curr.right==null)
            || (prev!=null && (prev == curr.left || prev==curr.right))){
                result.add(curr.val);
                prev = curr;
                stack.pop();
            }else{
                if(curr.right!=null){
                    stack.push(curr.right);
                }
                if(curr.left != null){
                    stack.push(curr.left);
                }
            }
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
        return validBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
    //108. Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);
        }
        int middle = nums.length / 2;
        TreeNode node = new TreeNode(nums[middle]);
        int[] leftA = Arrays.copyOfRange(nums, 0, middle);
        int[] rightA = Arrays.copyOfRange(nums, middle+1, nums.length);
        node.left = sortedArrayToBST(leftA);
        node.right = sortedArrayToBST(rightA);
        return node;
    }
    //114. Flatten Binary Tree to Linked List
    private TreeNode prev = null;
    public void flatten(TreeNode root){
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    public void flatten_org(TreeNode root){
        if(root==null){
            return;
        }
        if(root.right!=null&&root.left!=null){
            flatten_org(root.left);
            flatten_org(root.right);
            TreeNode tmp = root.right;
            root.right = root.left;
            TreeNode curr = root.left;
            while(curr.right!=null){
                curr = curr.right;
            }
            curr.right = tmp;
            root.left = null;
        }else if(root.right!=null){
            flatten_org(root.right);
        }else if(root.left!=null){
            flatten_org(root.left);
            root.right = root.left;
            root.left = null;
        }
    }
    public void flatten_non_recursive(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        while(root!=null){
            if(root.left==null){
                root = root.right;
                continue;
            }
            TreeNode left = root.left;
            while(left.right!=null){
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }
    //116. Populating Next Right Pointers in Each Node
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while(pre.left!=null){
            cur = pre;
            while(cur!=null){
                cur.left.next = cur.right;
                if(cur.next!=null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
    //113. Path Sum II
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root==null){
            return result;
        }
        runPath(root, sum, path, result);
        return result;
    }
    private void runPath(TreeNode root, int currSum, List<Integer> path, List<List<Integer>> result){
        //System.out.println(Arrays.toString(path.toArray()));
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){//hit leaf
            if(root.val==currSum){
                path.add(root.val);
                result.add(path);
            }
        }else{
            path.add(root.val);
            List<Integer> leftPath = new ArrayList<>();
            leftPath.addAll(path);
            List<Integer> rightPath = new ArrayList<>();
            rightPath.addAll(path);
            runPath(root.left, currSum - root.val, leftPath, result);
            runPath(root.right, currSum - root.val, rightPath, result);
        }
    }
    //129. Sum Root to Leaf Numbers
    public int sumNumbers_s(TreeNode root) {
        return countPath(root, 0);
    }
    private int countPath(TreeNode n, int sum){
        if(n==null){
            return 0;
        }
        if(n.left==null&&n.right==null){
            return sum*10 + n.val;
        }
        return countPath(n.left, sum*10+n.val) + countPath(n.right, sum*10+n.val);
    }
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        sumNumbersHelper(root, path, result);
        int sum = 0;
        for(List<Integer> number : result){
            int part = 0;
            for(int i=0;i<number.size();i++){
                part += number.get(i) * Math.pow(10, number.size()-i-1);
            }
            sum+=part;
        }
        return sum;
    }
    private void sumNumbersHelper(TreeNode node, List<Integer> path, List<List<Integer>> result){
        if(node==null){
            return;
        }
        path.add(node.val);
        if(node.left==null&&node.right==null){
            result.add(path);
        }else{
            List<Integer> leftPath = new ArrayList<>();
            List<Integer> rightPath = new ArrayList<>();
            leftPath.addAll(path);
            rightPath.addAll(path);
            sumNumbersHelper(node.left, leftPath, result);
            sumNumbersHelper(node.right, rightPath, result);
        }
    }
    //199. Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int preLevelCnt = q.size();
            for(int i=0; i<preLevelCnt; i++){
                TreeNode tmp = q.poll();
                if(tmp.left!=null){
                    q.add(tmp.left);
                }
                if(tmp.right!=null){
                    q.add(tmp.right);
                }
                if(i==preLevelCnt-1){
                    res.add(tmp.val);
                }
            }
        }
        return res;
    }
    //222. Count Complete Tree Nodes
    public int countNodes1(TreeNode root){
        if(root==null){
            return 0;
        }
        int level = helperLeft(root);
        int completeNodes = (int) Math.pow(2, level-1) - 1;
        //find leaves
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelCnt = 0;
        while(!q.isEmpty()){
            levelCnt = q.size();
            for(int i=0; i<levelCnt; i++){
                TreeNode tmp = q.poll();
                if(tmp.left!=null){
                    q.add(tmp.left);
                }
                if(tmp.right!=null){
                    q.add(tmp.right);
                }
            }
        }
        return completeNodes + levelCnt;
    }
    public int countNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        int levelLeft = helperLeft(root.left);
        int count = 1;
        int middle = helperLeft(root.right);
        if(levelLeft==middle){
            count += (1<< levelLeft) - 1;
            count += countNodes(root.right);
        }else{
            count += (1<< middle) - 1;
            count += countNodes(root.left);
        }
        return count;
    }
    private int helperLeft(TreeNode root){
        if(root==null){
            return 0;
        }else{
            return 1 + helperLeft(root.left);
        }
    }
    //230. Kth Smallest Element in a BST
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){//visit, and check the k
                if(k==1){
                    return cur.val;
                }
                k--;
                cur = cur.right;
            }else{
                TreeNode prev = cur.left;
                while(prev.right!=null&&prev.right!=cur){
                    prev = prev.right;
                }
                //two case left  :
                //1. prev.right==null
                if(prev.right==null){
                    prev.right = cur;
                    cur = cur.left;
                }else{ // met before, print it
                    if(k==1){
                        return cur.val;
                    }
                    k--;
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return 0;
    }
	public int kthSmallest_inorder(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode cur = root;
		while(!st.empty()||cur!=null){
			if(cur!=null){
				st.push(cur);
				cur = cur.left;
			}else{
				cur = st.pop();
				k--;
				if(k==0){
					return cur.val;
				}
				cur = cur.right;
			}
		}
		return -1;
	}
    //List all nodes at the same level
    public List<List<TreeNode>> getSameLevelNode(TreeNode root){
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<TreeNode> level = new ArrayList<>();
            TreeNode node = queue.poll();
            while(node != null){
                level.add(node);
                node = queue.poll();
            }
            for(TreeNode n : level){
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
            result.add(level);
        }
        return result;
    }
	// Geek for geek amazon interview question
	public boolean isSumTree(TreeNode root){
		if(root.left==null&&root.right==null){
			return true;
		}else if(root.left==null){
			if(root.left.val == root.val){
				return true;
			}else{
				return false;
			}
		}else if(root.right==null){
			if(root.left.val == root.val){
				return true;
			}else{
				return false;
			}
		}else{
			if(root.left.val+root.right.val==root.val){
				return true && isSumTree(root.left) && isSumTree(root.right);
			}
			return false;
		}
	}
	public void traverseRound(TreeNode root){
		System.out.println(root.val);
		printLeft(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRight(root.right);
	}
	private void printLeft(TreeNode root){
		if(root!=null){
			if(root.left!=null){
				//System.out.println(root.val);
				printLeft(root.left);
			}else if(root.right!=null){
				//System.out.println(root.val);
				printLeft(root.right);
			}
		}
	}
	private void printRight(TreeNode root){
		if(root!=null){
			if(root.right!=null){
				printRight(root.right);
				//System.out.println(root.val);
			}else if(root.left!=null){
				printRight(root.left);
				//System.out.println(root.val);
			}
		}
	}
	private void printLeaves(TreeNode root){
		if(root!=null){
			if(root.left==null&&root.right==null){
				//System.out.println(root.val);
				return;
			}
			printLeaves(root.left);
			printLeaves(root.right);
		}
	}
	public TreeNode mergeTree(TreeNode root1, TreeNode root2){
		List<Integer> l1 = inorderTraversal_s(root1);
		List<Integer> l2 = inorderTraversal_s(root2);
		int i=0;
		int j=0;
		int k=0;
		int[] mergeArray = new int[l1.size()+l2.size()];
		while(i<l1.size()||j<l2.size()){
			if(i>=l1.size()){
				mergeArray[k++] = l2.get(j++);
				continue;
			}
			if(j>=l2.size()){
				mergeArray[k++] = l1.get(i++);
				continue;
			}
			if(l1.get(i)<l2.get(j)){
				mergeArray[k++] = l1.get(i++);
			}else{
				mergeArray[k++] = l2.get(j++);
			}
		}
		return constPractice(mergeArray, 0, mergeArray.length-1);
	}
	private TreeNode constPractice(int[] arr, int start, int end){
		if(start==end){
			return new TreeNode(arr[start]);
		}
		if(end<start){
			return null;
		}
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = constPractice(arr, start, mid-1);
		root.right = constPractice(arr, mid+1, end);
		return root;
	}
	// max consecutive path
	public int maxConsecutive(TreeNode root){
		List<Integer> max = new ArrayList<>();
		max.add(0);
		consecutiveHelper(root, root.val, 0, max);
		if(max.get(0)==1){
			return -1;
		}
		return max.get(0);
	}
	private void consecutiveHelper(TreeNode root, int expect, int path, List<Integer> max){
		if(root==null){
			return;
		}
		if(root.val!=expect){
			path=1;
		}else{
			path++;
		}
		//update max path
		Integer curMax = max.get(0);
		curMax = Math.max(curMax, path);
		max.add(0, curMax);
		consecutiveHelper(root.left, root.val+1, path, max);
		consecutiveHelper(root.right, root.val+1, path, max);
	}

	public int findMirror(TreeNode root, int find){
		if(root.val == find){
			return root.val;
		}
		return findMirrorRec(root.left, root.right, find);
	}
	private int findMirrorRec(TreeNode left, TreeNode right, int find){
		if(left==null||right==null){
			return -1;
		}
		if(left.val==find){
			return right.val;
		}
		if(right.val==find){
			return left.val;
		}
		int res = findMirrorRec(left.left, right.right, find);
		if(res!=-1){
			return res;
		}else{
			return findMirrorRec(left.right, right.left, find);
		}
	}
	//124. Binary Tree Maximum Path Sum
	int maxValue = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxValue = Integer.MIN_VALUE;
		mpsHelper(root);
		return maxValue;
    }
	private int mpsHelper(TreeNode root){
		if(root==null){
			return 0;
		}
		if(root.left==null&&root.right==null){
			return root.val;
		}
		int l = Math.max(0, mpsHelper(root.left));
		int r = Math.max(0, mpsHelper(root.right));
		//try root+left, root+right, root it self and left+right+itselft
		int ro = root.val;
		maxValue = Math.max(maxValue, l+r+ro);
		return root.val+ Math.max(l, r);
	}
	public int maxLevelSum(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int max = 0;
		q.add(root);
		while(!q.isEmpty()){
			int count = q.size();
			int sum = 0;
			while(count>0){
				TreeNode node  = q.poll();
				if(node.left!=null){
					q.add(node.left);
				}
				if(node.right!=null){
					q.add(node.right);
				}
				sum += node.val;
				count--;
			}
			max = Math.max(max, sum);
		}
		return max;
	}
	public void swapTree(TreeNode root){
		Map<String, TreeNode> ptrs = new HashMap<>();
		ptrs.put("prev", null);
		ptrs.put("first", null);
		ptrs.put("middle", null);
		ptrs.put("second", null);
		swapHelper(root, ptrs);
		TreeNode first = ptrs.get("first");
		TreeNode middle = ptrs.get("middle");
		TreeNode second  = ptrs.get("second");
		if(first!=null&&second!=null){
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}else if(first!=null&&middle==null){
			int tmp = first.val;
			first.val = middle.val;
			middle.val = tmp;
		}
	}
	private void swapHelper(TreeNode root, Map<String, TreeNode> ptrs){
		if(root!=null){
			swapHelper(root.left, ptrs);
			TreeNode prev = ptrs.get("prev");
			TreeNode first = ptrs.get("first");
			TreeNode middle = ptrs.get("middle");
			TreeNode second = ptrs.get("second");
			if(prev!=null&&prev.val > root.val){
				if(first==null){
					first = prev;
					middle = root;
				}else{
					second = root;
				}
			}
			ptrs.put("first", first);
			ptrs.put("middle", middle);
			ptrs.put("second", second);
			prev = root;
			ptrs.put("prev", prev);
			swapHelper(root.right, ptrs);
		}
	}
	public void getInorderLeave(TreeNode root){
		if(root!=null){
			getInorderLeave(root.left);
			if(root.left==null&&root.right==null){//is child
			}
			getInorderLeave(root.right);
		}
	}
	public int findDistance(TreeNode root, TreeNode p, TreeNode q){
		TreeNode lca = getLCA(root, p, q);
		int ro = getDistance(root, lca, 0);
		int l = getDistance(root, p, 0);
		int r = getDistance(root, q, 0);
		return l+r-2*ro;
	}
	public TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q){
		if(root==null){
			return null;
		}
		if(root.val == p.val){
			return root;
		}
		if(root.val == q.val){
			return root;
		}
		TreeNode leftLCA = getLCA(root.left, p, q);
		TreeNode rightLCA = getLCA(root.right, p, q);
		if(leftLCA!=null&&rightLCA!=null){
			return root;
		}else if(leftLCA!=null){
			return leftLCA;
		}else if(rightLCA!=null){
			return rightLCA;
		}
		return null;
	}
	public int getDistance(TreeNode root, TreeNode target, int dis){
		if(root==null){
			return -1;
		}
		if(root.val==target.val){
			return dis;
		}else{
			int l = getDistance(root.left, target, dis+1);
			int r = getDistance(root.right, target, dis+1);
			if(l==-1){
				return r;
			}else{
				return l;
			}
		}
	}
	public List<List<Integer>> diagonalTree(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		diagonalHelper(root, result, 0);
		return result;
	}
	private void diagonalHelper(TreeNode root, List<List<Integer>> result, int level){
		if(root==null){
			return;
		}
		if(result.size()==level){
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(root.val);
		diagonalHelper(root.left, result, level+1);
		diagonalHelper(root.right, result, level);
		return;
	}
	public int height(TreeNode root){
		if(root==null){
			return 0;
		}
		int max = Math.max(height(root.left), height(root.right));
		return max+1;
	}
	public int diameter(TreeNode root, int[] height){
		if(root==null){
			height[0] = 0;
			return 0;
		}
		int[] tmpl = new int[1];
		int[] tmpr = new int[1];
		int ld = diameter(root.left, tmpl);
		int lr = diameter(root.right, tmpr);
		height[0] = Math.max(tmpl[0], tmpr[0]) + 1;
		return Math.max(tmpl[0]+tmpr[0]+1, Math.max(ld, lr));
	}
}
