import java.util.ArrayList;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
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

    public static void preorder(Node root) {
        if(root==null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
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

    public static Node createBST(int values[], int start, int end) {
        if(start>end) {
            return null;
        }
        int mid = start+((end-start)/2);

        Node root = new Node(values[mid]);
        root.left = createBST(values, start, mid-1);
        root.right = createBST(values, mid+1, end);

        return root;

    }

    //Convert BST to Balanced BST
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root==null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBSTForBalancedBST(ArrayList<Integer> inorder, int start, int end) {
        if(start>end) {
            return null;
        }
        int mid=(start+end)/2;

        Node root = new Node(inorder.get(mid));
        root.left = createBSTForBalancedBST(inorder, start, mid-1);
        root.right = createBSTForBalancedBST(inorder, mid+1, end);
        return root;
    }

    public static Node balancedBST(Node root) {
        //inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //inorder -> Balanced BST
        root = createBSTForBalancedBST(inorder, 0, inorder.size()-1);
        return root;
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    
    public static int maxBST = 0;
    public static Info largestBST(Node root) {
        if(root==null) {
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false,size,min,max);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true,size,min,max);
        }

        return new Info(false,size,min,max);
    }

    public static Node mergeBSTs(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        ArrayList<Integer> sortedArr = new ArrayList<>();

        int pt1 = 0, pt2 = 0;
        while(pt1 < arr1.size() && pt2 < arr2.size()) {
            if(arr1.get(pt1) < arr2.get(pt2)) {
                sortedArr.add(arr1.get(pt1));
                pt1++;
            }
            else {
                sortedArr.add(arr2.get(pt2));
                pt2++;
            }
        }

        while(pt1 < arr1.size()) {
            sortedArr.add(arr1.get(pt1));
            pt1++;
        }

        while(pt2 < arr2.size()) {
            sortedArr.add(arr2.get(pt2));
            pt2++;
        }

        Node root = createBSTForBalancedBST(sortedArr, 0, sortedArr.size()-1);
        return root;
    }

    public static void main(String[] args) {
        // int values[] = {5,1,3,4,2,7};
        // int values[] = {8,5,3,1,4,6,10,11,14};
        // int values[] = {8,8,8};
        // Node root = null;

        // for(int i=0; i<values.length; i++) {
        //     root = insert(root, values[i]);
        // }
        
        // inorder(root);
        // System.out.println();
        
        // System.out.println(searchNode(root,22));
        
        // root = delete(root, 1);
        // inorder(root);
        
        // printInRange(root, 5, 14);
        
        // rootToLeafPath(root, new ArrayList<>());
        
        // System.out.println(validBST(root, null, null));
        
        // root = mirrorBST(root);
        // inorder(root);
        // System.out.println();
        
        // int values[] = {3,5,6,8,10,11,12};
        // Node root = createBST(values, 0, values.length-1);
        
        // inorder(root);
        // System.out.println();
        // preorder(root);
        
        // // Convert BST to Balanced BST
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);
        
        // preorder(root);
        // System.out.println();
        // // OR
        // int values[] = {8,6,5,3,10,11,12};
        // Node root=null;
        // for(int i=0; i<values.length; i++) {
        //     root = insert(root, values[i]);
        // }

        // root = balancedBST(root);
        // preorder(root);

        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);
        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(85);
        // largestBST(root);
        // System.out.println(maxBST);

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1,root2);
        preorder(root);
    }
}
