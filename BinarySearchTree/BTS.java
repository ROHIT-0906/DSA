
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

    public static void main(String[] args) {
        int val[] = {5,1,3,4,2,7,10,9,8,11};
        Node root = null;

        for(int i = 0; i<val.length; i++){
            root = insert(root, val[i]);
        }

        // inorder(root);
        // System.out.println();
        // levelOrder(root);

        int key = 15;
        
        System.out.println(isExist(root, key));
    }

}