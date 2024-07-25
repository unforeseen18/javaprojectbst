//implementation of operation insert and search in  binary search tree .
import java.util.*;
public class BinarySearchTree{
    static class Node{
        int data;
        Node left;
        Node right;
    
    Node(int data){
        this.data=data;
    }
    }
    public static Node insert(Node root,int val){      //
        if(root==null){                                //
            root=new Node(val);                        //
            return root;                               //
        }                                              //
        if(root.data>val){                             ////(insertion)
            root.left=insert(root.left,val);           //
        }                                              //
        else{                                         // 
            root.right=insert(root.right,val);        // 
        }                                             // 
        return root;                                  // 
    }                                                  //
    public static boolean search(Node root,int key){  // 
        if(root==null){                               // 
            return false;                             //
        }                                             // 
        if(root.data>key){                            // 
            return search(root.left,key);             // 
        }                                             // //(search)
        else if(root.data==key){                      // 
            return true;                              // 
        }                                            //  
        else{                                         // 
            return search(root.right,key);            // 
        }                                            //  
    }                                                //  
    public static void inorder(Node root){           //  
        if(root==null){                              //   
            return;                                  //  
        }                                            //  //(Indorder traversal)
        inorder(root.left);                          //  
        System.out.print(root.data+" ");             //  
        inorder(root.right);                         //  
    }   
    //delete function implementation
    public static Node delete(Node root, int val){   //  
        if(root.data>val){                            // 
            root.left=delete(root.left,val);         //  
        }                                            //  
        else if(root.data<val){                       // 
            root.right=delete(root.right,val);       //  
        }                                           //   
        else{//root.data==val                            
        //case1                                          
        if(root.left==null && root.right==null){      // 
            return null;                              // //(deletion)
        }                                             // 
        //case2                                          
        if(root.left==null){                         //  
            return root.right;                       //  
        }                                             // 
        else if(root.right==null){                 //    
            return root.left;                      //    
        }                                            //  
         //case3                                         
         Node IS=inorderSuccessor(root.right);       //  
         root.data=IS.data;                          //  
         root.right=delete(root.right,IS.data);      //  
        }                                            //  
        return root;                                 //  
    }                                                 // 
    public static Node inorderSuccessor(Node root){  // 
        while(root.left !=null){                      // 
            root=root.left;                           // 
        }                                              //
        return root;                                   //
    }                                                  //
    public static void main(String[] args){
        // int values[]={8,9,2,4,3,5,6};
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter size :");
        int n=sc.nextInt();
        int values[]=new int[n];
        for(int i=0;i<n;i++){
           values[i]=sc.nextInt();
       }
       System.out.println("please enter key want to search:");
       int key=sc.nextInt();
       
       
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }
        System.out.println("inorder traversal");
        inorder(root);
        System.out.println();
        if(search(root,key))
        {
            System.out.println(" The key is Found");
        }
        else{
            System.out.println("The key is not found");
        }
        System.out.println("after deletion");
        delete(root,4);
        inorder(root);
    }

    }
