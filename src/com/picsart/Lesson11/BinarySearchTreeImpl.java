package com.picsart.Lesson11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeImpl {

    Node root;

    public BinarySearchTreeImpl(int val) {
        root = new Node(val);
    }

    public BinarySearchTreeImpl() {
        root = null;
    }

    public void insert(int val) {
        root = insertData(root, val);
    }

    private Node insertData(Node root, int val) {
        if (root == null) {
            return new Node(val);

        }
        if (val < root.val) {
            root.left = insertData(root.left, val);
        } else if (val > root.val) {
            root.right = insertData(root.right, val);
        }
        return root;
    }

    public void delete(int val) {
        root = deleteVal(root, val);
    }

    private Node deleteVal(Node root, int val) {

        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = deleteVal(root.left, val);
        } else if (val > root.val) {
            root.right = deleteVal(root.right, val);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.val = findMin();
            root.right = deleteVal(root.right, root.val);
        }
        return root;
    }


    public int findMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }

    public int findMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.val;
    }

    public boolean contains(int val) {
        return search(root, val) != null;
    }

    private Node search(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }
        if (val > root.val) {
            return search(root.right, val);
        }
        return search(root.left, val);

    }

    public void bfs() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.val);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void depthFirstSearch() {
        if (root == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();


            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }

            System.out.println(node.val + " ");
        }
    }

    String printTree() {
        return toString(root);
    }

    private String toString(Node root) {
        String result = "";
        if (root == null)
            return "";
        result += toString(root.left);
        result += toString(root.right);
        result = result + root.val + " ";
        return result;
    }
}
