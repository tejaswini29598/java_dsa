import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
         val = x; 
     }
}

public class InsertNodeInBST {
    // Insert value into BST
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val)
           root.left = insertIntoBST(root.left, val);
        else 
           root.right = insertIntoBST(root.right, val);
        return root;
    }

    // Build tree from level order input
    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].isEmpty()) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);        
        int i = 1;
        while (i < nodes.length) {
            TreeNode curr = queue.poll();
            if (i < nodes.length && !nodes[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // Level order traversal with nulls
    public static String levelOrder(TreeNode root) {
        if (root == null) return "";
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                res.add("null");
            }
        }
        // Remove trailing "null"s
        int idx = res.size() - 1;
        while (idx >= 0 && res.get(idx).equals("null")) idx--;
        return String.join(" ", res.subList(0, idx + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.hasNextLine() ? sc.nextLine().trim() : "";
        String line2 = sc.hasNextLine() ? sc.nextLine().trim() : "";
        String[] nodes = line1.isEmpty() ? new String[0] : line1.split(" ");
        int val = Integer.parseInt(line2);
        TreeNode root = buildTree(nodes);
        root = insertIntoBST(root, val);
        System.out.println(levelOrder(root));
    }
}