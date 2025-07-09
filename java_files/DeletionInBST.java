import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class DeletionInBST {
    // Insert a node into BST
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // Delete a node from BST
    static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // Node with two children: get inorder successor (smallest in right subtree)

            //replacing the deleted node with the minimum node in the right subtree or replacing with immediate inorder successor
            /*
             * Sample Input:
            5 3 6 2 4 7 
            3
           Sample Output:
             2 4 5 6 7  (after deletion of '3' this is final inorder traversal of the tree)

             Explanation:
            The BST is constructed as:
        5
       / \
      3   6  (inorder:234567 so,here the immediate inorder successor of 3 is '4' so after the deletion we are inserting 4 at the place of '3')
     / \   \
    2   4   7
   After deleting node 3, its right child 4 replaces it. The in-order traversal is 2 4 5 6 7.
             */
            TreeNode minNode = root.right;
            while (minNode.left != null) minNode = minNode.left;
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
            
            
            /*  TreeNode minNode = root.left;
             while(minNode.right!= null) minNode=minNode.right;
              root.val=minNode.val;
             root.left =deleteNode(root.left,minNode.val);
             */
        }
        return root;
    }

    // In-order traversal
    static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] vals = sc.nextLine().trim().split("\\s+");
        int key = Integer.parseInt(sc.nextLine().trim());
        TreeNode root = null;
        for (String v : vals) {
            if (!v.isEmpty())
                root = insert(root, Integer.parseInt(v));
        }
        root = deleteNode(root, key);
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(res.get(i));
        }
    }
}