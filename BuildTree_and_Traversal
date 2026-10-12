
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Tree {
    Node root;

    void buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            root = null;
            return;
        }

        Queue<Node> q = new LinkedList<>();

        root = new Node(arr[0]);
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();


            if (i < arr.length && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;


            if (i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements (-1 for null):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Tree tree = new Tree();
        tree.buildTree(arr);

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);

        sc.close();
    }
}
