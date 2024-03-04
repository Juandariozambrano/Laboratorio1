import java.util.Scanner;

public class arbolbinariodebusqueda {
    private Node root;

    private class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public arbolbinariodebusqueda() {
        root = null;
    }

    public void add(int data) {
        root = addRecursive(root, data);
    }

    private Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            // Value already exists in the tree
            return current;
        }

        return current;
    }

    public boolean contains(int data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(Node current, int data) {
        if (current == null) {
            return false;
        }

        if (data < current.data) {
            return containsRecursive(current.left, data);
        } else if (data > current.data) {
            return containsRecursive(current.right, data);
        } else {
            return true;
        }
    }

    public void remove(int data) {
        root = removeRecursive(root, data);
    }

    private Node removeRecursive(Node current, int data) {
        if (current == null) {
            return current;
        }

        if (data < current.data) {
            current.left = removeRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = removeRecursive(current.right, data);
        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            current.data = minValue(current.right);
            current.right = removeRecursive(current.right, current.data);
        }

        return current;
    }

    private int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        arbolbinariodebusqueda tree = new arbolbinariodebusqueda();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter an integer to add to the tree, 0 to exit:");
                int data = scanner.nextInt();
                if (data == 0) {
                    break;
                }
                tree.add(data);
            }

            while (true) {
                System.out.println("Enter an integer to search for in the tree, 0 to exit:");
                int data = scanner.nextInt();
                if (data == 0) {
                    break;
                }
                if (tree.contains(data)) {
                    System.out.println("The value " + data + " is in the tree.");
                } else {
                    System.out.println("The value " + data + " is not in the tree.");
                }
            }

            while (true) {
                System.out.println("Enter an integer to delete from the tree, 0 to exit:");
                int data = scanner.nextInt();
                if (data == 0) {
                    break;
                }
                tree.remove(data);
                System.out.println("The value " + data + " has been removed from the tree.");
            }
        }
    }
}
