
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesB {
    // create a node class
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // create a binary tree class
    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root){
            if(root == null){
                return;
            }
            
            // order - root-left-right
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){
            if(root == null){
                return;
            }

            // order - left-right-root
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public static void postorder(Node root){
            if(root == null){
                return;
            }
            // order - left-right-root
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root){
            if(root == null) return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                Node currNode = queue.poll();
                System.out.print(currNode.data+" ");

                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
        }
        
        public static int countOfNodes(Node root){
            if(root == null) return 0;

            int leftCount = countOfNodes(root.left);
            int rightCount = countOfNodes(root.right); 

            // combining count of left sub-tree + right sub-tree + current node as 1
            return leftCount + rightCount + 1;
        }

        public static int sumOfNodes(Node root){
            if(root == null) return 0;

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            // combining Sum of left sub-tree + right sub-tree + current node data 
            return leftSum + rightSum + root.data;
        }

        public static int height(Node root){
            if(root == null) return 0;

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    public static void main(String[] args){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);
        // tree.levelOrder(root);

        System.err.println("Total number of nodes in tree : "+tree.countOfNodes(root));
        System.err.println("Total Sum of nodes in tree : "+tree.sumOfNodes(root));
        System.err.println("Height of tree : "+tree.height(root));
    }
}
