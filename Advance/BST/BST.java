import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root==null){
           root = new Node(val);
           return root;
        }

        if(root.data > val){
            // left subtree
            root.left = insert(root.left, val);
        }else{
            // right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean search(Node root, int val){
        if(root == null) return false;

        if(root.data == val){
            return true;
        }else if(root.data > val){
            // search in left subtree
            return search(root.left, val);
        }else{
            // search in right subtree
            return search(root.right, val);
        }
    }

    public static Node delete(Node root, int val){
        // If value does not exist
        if(root == null) return null;

        if(root.data > val){
            root.left = delete(root.left, val);
        }else if(root.data < val){
            root.right = delete(root.right, val);
        }else{
            // root.data == val
            // case 1 : No child (Leaf node) => Delete node and return null to parent
            if(root.left == null && root.right == null){
                return null;
            }

            // case 2 : single child => Delete node and replace with child node
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // case 3 : Two childeren => Replace value with Inorder Successor, Delete node of Inorder Successor
            // if children also have children then find left most node from right subtree
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data); // Deleting Inorder successor
        }

        return root;
    }

    // function to get left most node from right subtree (i.e successor of previous node)
    public static Node inOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public static void printInRange(Node root, int X, int Y){
        if(root == null) return;
        
        if(root.data >= X && root.data <= Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data+" ");
            printInRange(root.right, X, Y);
        }
        else if(root.data >= Y){
            printInRange(root.left, X, Y);
        }
        else{
            printInRange(root.right, X, Y);
        }
    }

    public static void printRoot2LeafPath(Node root, ArrayList<Integer> path){
        if(root==null) return;
        
        path.add(root.data);

        // At leaf node, print the current path
        if(root.left == null && root.right == null){
            printPath(path);
        }else{
            printRoot2LeafPath(root.left, path);
            printRoot2LeafPath(root.right, path);
        }

        // remove last added value and backtrack
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path){
        for(int p : path){
            System.out.print(p+"->");
        }
        System.out.println();
    }

    public static void inorder(Node root){
        if(root==null) return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        boolean find = search(root, 3);

        if(find){
            System.out.println("FOUND");
        }else{
            System.out.println("NOT FOUND");
        }

        // delete(root, 4);
        // delete(root, 5);
        // delete(root, 10);
        // delete(root, 555);
        
        inorder(root);

        System.out.println();
        printInRange(root, 6, 11);

        System.out.println();
        printRoot2LeafPath(root, new ArrayList<>());
    }
}
