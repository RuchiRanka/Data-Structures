import java.lang.foreign.VaList;
import java.util.ArrayList;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if(root==null) {
            root = new Node(val);
            return root;
        }
        
        if(root.data > val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if(root==null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean searchNode(Node root, int key) {
        if(root==null) {
            return false;
        }
        if(root.data==key) {
            return true;
        }
        else if(root.data>key) {
            return searchNode(root.left, key);
        }
        else {
            return searchNode(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        //Searching
        if(root.data > val) {
            root.left = delete(root.left, val);
        }

        else if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else {  //root.data == val
            //case 1 - leaf node
            if(root.left==null && root.right==null) {
                return null;
            }

            //case 2 - one child
            if(root.left==null) {
                return root.right;
            }
            else if(root.right==null) {
                return root.left;
            }

            //case 3 - two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while(root.left!=null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root==null) {
            return;
        }

        if(root.data>=k1 && root.data<=k2) {
            printInRange(root.left, k1, k2);
            System.out.println(root.data);
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1) {
            printInRange(root.right, k1, k2);
        } 
        else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void rootToLeafPath(Node root, ArrayList<Integer> path) {
        if(root==null) {
            return;
        }

        path.add(root.data);
        if(root.left==null && root.right==null) {
            printPath(path);
            System.out.println();
        }
        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.print("Null");
    }

    public static boolean validBST(Node root, Node min, Node max) {
        if(root==null) {
            return true;
        }

        if(min!=null && root.data<=min.data) {
            return false;
        }
        else if(max!=null && root.data>=max.data) {
            return false;
        }

        return validBST(root.left, min, root) && validBST(root.right, root, max);
    }

    public static Node mirrorBST(Node root) {
        if(root==null) {
            return null;
        }

        Node tempRight = root.right;
        root.right = mirrorBST(root.left);
        root.left = mirrorBST(tempRight);

        return root;
    }

    public static void main(String[] args) {
        // int values[] = {5,1,3,4,2,7};
        int values[] = {8,5,3,1,4,6,10,11,14};
        // int values[] = {8,8,8};
        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
        
        // System.out.println(searchNode(root,22));
        
        // root = delete(root, 1);
        // inorder(root);
        
        // printInRange(root, 5, 14);
        
        // rootToLeafPath(root, new ArrayList<>());
        
        // System.out.println(validBST(root, null, null));
        
        root = mirrorBST(root);
        inorder(root);
        System.out.println();
    }
}
