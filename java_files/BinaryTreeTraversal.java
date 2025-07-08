import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class BinaryTreeTraversal {
    static Map<Integer, TreeNode> nodes = new HashMap<>();
    static Set<Integer> children = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] input = new int[N][3];
        for (int i = 0; i < N; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            input[i][2] = sc.nextInt();
        }
        for (int[] arr : input) {
            nodes.putIfAbsent(arr[0], new TreeNode(arr[0]));
            /*
             * if (arr[1] != -1) {
Checks if the left child exists (if the value is not -1, which means no child).

nodes.putIfAbsent(arr[1], new TreeNode(arr[1]));
If the left child node does not already exist in the nodes map, create and add it.

nodes.get(arr[0]).left = nodes.get(arr[1]);
Sets the left child of the current node (arr[0]) to the node with value arr[1].

children.add(arr[1]);
Adds the left child value to the children set, which helps track which nodes are children (not roots).

In summary:
This block ensures that if a left child exists for the current node, it is created (if not already present), linked as the left child, and recorded as a child node.
             */
            if (arr[1] != -1) {
                nodes.putIfAbsent(arr[1], new TreeNode(arr[1]));
                nodes.get(arr[0]).left = nodes.get(arr[1]);
                children.add(arr[1]);
            }
            //for right child
            if (arr[2] != -1) {
                nodes.putIfAbsent(arr[2], new TreeNode(arr[2]));
                nodes.get(arr[0]).right = nodes.get(arr[2]);
                children.add(arr[2]);
            }
        }
        int rootVal = input[0][0];
        TreeNode root = nodes.get(rootVal);

        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        inorder(root, inorder);
        preorder(root, preorder);
        postorder(root, postorder);

        printList(inorder);
        printList(preorder);
        printList(postorder);
    }

    static void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    static void preorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }

    static void postorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }

    static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(list.get(i));
        }
        System.out.println();
    }
}