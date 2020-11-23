public class HouseRobber3 {
    //visualize as binary tree - we can't rob linked houses
    public int rob(TreeNode root) {
        if(root == null)
            return 0;

        int val = 0;

        //calculate of next subtree - 4 grandchildren
        if(root.left != null)
            val += rob(root.left.left) + rob(root.left.right);

        if(root.right != null)
            val += rob(root.right.left) + rob(root.right.right);

        //max of root + next to next subtree or dont take root and continue on right and left
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}
