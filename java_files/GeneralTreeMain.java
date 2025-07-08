import java.util.*;

class Node {
    int val;
    List<Node> children;
    Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

class GeneralTree {
    Node root;
    Map<Integer, Node> nodeMap;

    public GeneralTree() {
        root = new Node(1); //1 node insertion 
        nodeMap = new HashMap<>();
        nodeMap.put(1, root); //placing 1 as root
    }

    public void insert(int parent, int value) {
        Node parentNode = nodeMap.get(parent);
        Node newNode = new Node(value); //inserting values
        parentNode.children.add(newNode); //adding new nodes for insertion values
        nodeMap.put(value, newNode);
    }

    public void delete(int value) {
        if (value == 1) return; // Cannot delete root
        Node toDelete = nodeMap.get(value);
        for (Node node : nodeMap.values()) {
            node.children.removeIf(child -> child.val == value);
        }
        removeDescendants(toDelete);
    }
       //postorder deletion
    private void removeDescendants(Node node) {
        for (Node child : node.children) {
            removeDescendants(child);
        }
        nodeMap.remove(node.val);
    }

    public List<Integer> preorder() {
        List<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }

    private void preorderHelper(Node node, List<Integer> res) { //recursion
        if (node == null) return;
        res.add(node.val); //first add nodes
        for (Node child : node.children) { //after adding nodes , traverse all the nodes in preorder
            preorderHelper(child, res);
        }
    }

    public List<Integer> postorder() {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }

    private void postorderHelper(Node node, List<Integer> res) {
        if (node == null) return;
        for (Node child : node.children) { //first explore the children
            postorderHelper(child, res);
        }
        res.add(node.val); //then add nodes
    }
}

public class GeneralTreeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // number of operations
        GeneralTree tree = new GeneralTree();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            /*
             * if (parts[0].equals("insert")) {
Checks if the current command is "insert".

int parent = Integer.parseInt(parts[1]);
Reads the parent node's value from the input and converts it from a string to an integer.

int value = Integer.parseInt(parts[2]);
Reads the value of the new node to be inserted and converts it from a string to an integer.

tree.insert(parent, value);
Calls the insert method of the GeneralTree class to add a new node with the given value as a child of the node with value parent.

In summary:
This block processes an "insert" command, extracts the parent and new node values from the input, and inserts the new node as a child of the specified parent in the general tree.
             */
            if (parts[0].equals("insert")) {
                int parent = Integer.parseInt(parts[1]);
                int value = Integer.parseInt(parts[2]);
                tree.insert(parent, value);
            } else if (parts[0].equals("delete")) {
                int value = Integer.parseInt(parts[1]);
                tree.delete(value);
            } else if (parts[0].equals("preorder")) {
                List<Integer> res = tree.preorder();
                for (int j = 0; j < res.size(); j++) {
                    System.out.print(res.get(j));
                    if (j != res.size() - 1) System.out.print(" "); //printing preorder values with space seperated 
                }
                System.out.println();
            } else if (parts[0].equals("postorder")) {
                List<Integer> res = tree.postorder();
                for (int j = 0; j < res.size(); j++) {
                    System.out.print(res.get(j));
                    if (j != res.size() - 1) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}