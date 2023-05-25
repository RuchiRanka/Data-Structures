import java.util.*;
import java.util.LinkedList;
import java.util.HashMap;

public class BinaryTrees {

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree {
        static int index = -1;
        public static Node buildTree(int nodes[]) {
            index++;
            if(nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root) {
            if(root==null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if(root==null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if(root==null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(Node root) {
            if(root==null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    }
                    else {
                        q.add(null);
                    }
                }
                else {
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static int heightTree(Node root) {
        if(root==null) {
            return 0;
        }
        int lh = heightTree(root.left);
        int rh = heightTree(root.right);
        int height = Math.max(lh,rh)+1;
        return height;
    }

    public static int countNodes(Node root) {
        if(root==null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return (left+right+1);
    }

    public static int sumNodes(Node root) {
        if(root==null) {
            return 0;
        }
        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);
        return (leftSum + rightSum + root.data);
    }

    public static int diameterTree(Node root) {
        if(root==null) {
            return 0;
        }
        int leftDiam = diameterTree(root.left);
        int rightDiam = diameterTree(root.right);
        int lh = heightTree(root.left);
        int rh = heightTree(root.right);
        int selfDiam = lh + rh + 1;
        int max = Math.max(leftDiam, rightDiam);
        return Math.max(max, selfDiam);
    }

    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root) {
        if(root == null) {
            return new Info(0,0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if(node==null && subRoot==null) {
            return true;
        } else if(node==null || subRoot==null || node.data!=subRoot.data) {
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }

        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static class InfoTV {
        Node node;
        int hd;

        public InfoTV(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        Queue<InfoTV> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min=0, max=0;

        q.add(new InfoTV(root, 0));
        q.add(null);

        while(!q.isEmpty()) {
            InfoTV curr = q.remove();
            if(curr==null) {
                if(q.isEmpty()) {
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null) {
                    q.add(new InfoTV(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null) {
                    q.add(new InfoTV(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for(int i=min; i<=max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    //Iteratively
    public static void kthLevel(Node root, int k) {
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        q.add(null);
        int count = 1;

        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr==null) {
                if(q.isEmpty()) {
                    break;
                }
                else {
                    q.add(null);
                    count++;
                    if(count>k) {
                        return;
                    }
                }
            }
            else {
                if(count==k) {
                    System.out.println(curr.data);
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    //Recursively
    public static void KLevel(Node root, int level, int k) {
        if(root==null) {
            return;
        }

        if(level==k) {
            System.out.println(root.data);
            return;
        }

        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size()-1);
        return false; 
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> n1Path = new ArrayList<>();
        ArrayList<Node> n2Path = new ArrayList<>();

        getPath(root, n1, n1Path);
        getPath(root, n2, n2Path);

        int i=0;
        while(i < n1Path.size() && i < n2Path.size()) {
            if(n1Path.get(i) != n2Path.get(i)) {
                break;
            }
            i++;
        }

        Node lca = n1Path.get(i-1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if(root==null || root.data==n1 || root.data==n2) {
            return root;
        }

        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        if(leftLCA == null) {
            return rightLCA;
        }

        if(rightLCA == null) {
            return leftLCA;
        }

        return root;
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root,n1,n2);

        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1+dist2;
    }

    public static int lcaDist(Node root, int n) {
        if(root==null) {
            return -1;
        }
  
        if(root.data==n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist==-1 && rightDist==-1) {
            return -1;
        }
        else if(leftDist == -1) {
            return rightDist + 1;
        }
        else {
            return leftDist + 1;
        }
    }

    public static int kthAncestor(Node root, int n, int k) {
        if(root==null) {
            return -1;
        }

        if(root.data==n) {
            return 0;
        }

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if(leftDist==-1 && rightDist==-1) {
            return -1;
        }
        
        int max = Math.max(leftDist, rightDist);
        if(max+1==k) {
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int sumTree(Node root) {
        if(root==null) {
            return 0;
        }

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        int val = root.data;
        root.data = leftSum + rightSum;
        return val + leftSum + rightSum;
    }

    public static void main(String[] args) {
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree b = new BinaryTree();
        // Node root = b.buildTree(nodes);
        // System.out.println(root.data);

        // b.preorder(root);
        // b.inorder(root);
        // b.postorder(root);
        // b.levelorder(root);

        // // Height of the tree & Counting Nodes
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        // System.out.println(heightTree(root));
        // System.out.println(countNodes(root));
        // System.out.println(sumNodes(root));
        // System.out.println(diameterTree(root));
        // System.out.println(diameter2(root).diam);

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(isSubtree(root, subRoot));

        // topView(root);

        // kthLevel(root, 1);
        // KLevel(root, 1, 3);

        // int n1 = 2, n2 = 3;
        // System.out.println(lca(root, n1, n2).data);
        // System.out.println(lca2(root, n1, n2).data);

        // int n1 = 3, n2 = 7;
        // System.out.println(minDist(root, n1, n2));

        // int n=7, k=2;
        // kthAncestor(root, n, k);

        sumTree(root);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
        System.out.println(root.right.right.data);
        System.out.println(root.right.right.right.data);
    }
}
