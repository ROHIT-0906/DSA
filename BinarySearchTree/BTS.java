
import java.util.*;
public class BTS{
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
           root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;

    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

     public static boolean  isExist(Node root, int k){
            if(root == null){
                return false;
            }

            if(root.data == k){
                return true;
            }
             if(root.data > k){
               return isExist(root.left, k);
            }
            if(root.data<k){
                return isExist(root.right, k);
            }
            return false;
        }

        public static Node deleteNode(Node root, int val){
            if(root == null){
                return null;
            }
            if(root.data < val){
                root.right = deleteNode(root.right, val);
            }else if(root.data > val){
                root.left = deleteNode(root.left, val);
            }else{
                //case 1 leafNode
                if(root.left == null && root.right == null){
                    return null;
                }

                //case 2 is root has any one child

                if(root.left == null){
                    return root.right;
                }
                if(root.right == null){
                    return root.left;
                }

                //case 3 root has both childrens
                Node IS = findInorderSuccessor(root.right);
                root.data = IS.data;
                root.right = deleteNode(root.right, IS.data);
            }
            return root;
        }

        public static Node findInorderSuccessor(Node root){
            while(root.left != null){
                root = root.left;
            }
            return root;
        }

        public static void printInRange(Node root, int k1,int k2){
            if(root == null){
                return;
            }

            if(root.data >= k1 && root.data <= k2){
                printInRange(root.left, k1, k2);
                System.out.print(root.data+" ");
                printInRange(root.right, k1, k2);
            }else if(root.data < k1){
                printInRange(root.right, k1, k2);
            }else{
                printInRange(root.left, k1, k2);
            }
        }

        public static boolean isValid(Node root, Node min, Node max){
            if(root == null){
                return true;
            }

            if(min != null && root.data <= min.data){
                return false;
            }
            if(max != null && root.data >= max.data){
                return false;
            }

            return isValid(root.left, min, max) && isValid(root.right, min, max);
        }

        public static Node Mirror(Node root){
            if(root == null){
                return null;
            }

            Node leftTree = Mirror(root.left);
            root.left = Mirror(root.right);
            root.right = leftTree;
            return root;

        }

        public static void preorder(Node root){
            if(root == null){
                return;
            }

            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);

        }

        public static Node createBST(int val[], int st, int end){
            if(st > end){
                return null;
            }
            int mid = (st + end)/2;
            Node root = new Node(val[mid]);

            root.left = createBST(val, st, mid-1);
            root.right = createBST(val, mid+1, end);

            return root;
        }

    public static void main(String[] args) {
        int val[] = {3,5,6,8,10,11,12};
        Node root = null;

        for(int i = 0; i<val.length; i++){
            root = insert(root, val[i]);
        }

        root = createBST(val, 0, val.length-1);
        // inorder(root);
        // System.out.println();
        levelOrder(root);

        // // int key = 15;        
        // // System.out.println(isExist(root, key));

        //  root = deleteNode(root, 10);
        //  System.out.println();
        //  inorder(root);

        // printInRange(root, 3, 9);
        // root = Mirror(root);
        // preorder(root);

        
    }

}