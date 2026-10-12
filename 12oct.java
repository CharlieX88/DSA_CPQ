import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class IterativeBinaryTree {

    // 1. Iterative Level-Order Construction
    public static Node constructTree(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            Node current = queue.poll();

            // Insert Left Child
            if (i < arr.length) {
                current.left = new Node(arr[i++]);
                queue.add(current.left);
            }

            // Insert Right Child
            if (i < arr.length) {
                current.right = new Node(arr[i++]);
                queue.add(current.right);
            }
        }
        return root;
    }

    // 2. Iterative Preorder Traversal (Root -> Left -> Right)
    public static void printPreorder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");

            // Push right child first so left is processed first
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null)  stack.push(curr.left);
        }
    }

    // 3. Iterative Inorder Traversal (Left -> Root -> Right)
    public static void printInorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost Node of the current Node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.data + " ");

            // Move to the right subtree
            curr = curr.right;
        }
    }

    // 4. Iterative Postorder Traversal (Left -> Right -> Root) using 2 Stacks
    public static void printPostorder(Node root) {
        if (root == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()) {
            Node curr = s1.pop();
            s2.push(curr);

            // Push left and right children to s1
            if (curr.left != null)  s1.push(curr.left);
            if (curr.right != null) s1.push(curr.right);
        }

        // Print all elements from the second stack
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Input Array: " + Arrays.toString(arr));

        Node root = constructTree(arr);

        System.out.print("Iterative Inorder:   ");
        printInorder(root);
        System.out.println();

        System.out.print("Iterative Preorder:  ");
        printPreorder(root);
        System.out.println();

        System.out.print("Iterative Postorder: ");
        printPostorder(root);
        System.out.println();
    }
}
