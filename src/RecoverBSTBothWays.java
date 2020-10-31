class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val)
    {
      this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}

/*
Inorder of a BST gives array in ascending order,
we find two such pairs (since single node has been swapped as per question) where the prev is greater than current
from these two pairs, we swap first of pair1 with second of pair2 and retrieve the correct BST
 */
//The standard inorder traversal is recursive and uses stack space
//we use morris traversal to do this in constant space
public class RecoverBSTBothWays {

    TreeNode prevNode = null, firstNode = null, lastNode = null;
    TreeNode temp = null;

    //with auxiliary stack space
    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(firstNode, lastNode);
    }

    //this is Morris traversal - constant space
    public void recoverTreeMorris(TreeNode root)
    {
        while(root != null) {
            if (root.left != null) //left subtree exists
            {
                temp = root.left; //go left once
                while (temp.right != null && temp.right != root) //right subtree exists and we are not back to root
                {
                    temp = temp.right; //keep going right
                }
                //we have already connected the right pointer
                if (temp.right != null) {
                    //condition for finding the two nodes is met
                    if (prevNode != null && prevNode.val > root.val)
                        find(root);
                    prevNode = root;
                    temp.right = null;
                    root = root.right;
                } else { //if right was not connected
                    temp.right = root;
                    root = root.left;
                }
            } else //if left wasnt there
            {
                //check condition again
                if (prevNode != null && prevNode.val > root.val)
                    find(root);
                prevNode = root; //now root is previous
                root = root.right; //if left is null, keep going right
            }
        }
            //finally do the swap
            // swap two node values that we found
            if(firstNode != null && lastNode != null)
                swap(firstNode, lastNode);
    }

    //Helper methods
    public void inorder(TreeNode root){
        //this is with auxiliary stack space
        if(root == null)
            return;
        inorder(root.left);
        //do business
        if(prevNode != null && prevNode.val > root.val){
            find(root);
        }
        prevNode = root;
        inorder(root.right);
    }

    //find the two nodes to be swapped
    public void find(TreeNode root)
    {
        if(firstNode == null)
            firstNode = prevNode;
        lastNode = root;
    }

    //swap them
    public void swap(TreeNode firstNode, TreeNode lastNode){
        int t = firstNode.val;
        firstNode.val = lastNode.val;
        lastNode.val = t;
    }
}
