
/* Program overview: This program manipulate a binary tree where it reads from text file to insert and delete nodes. it also print the
order of the nodes visited for 3 cases traversal tree which are In-order, post-order, and pre-order
 * The program reads a comma seperated file and treat each column as a command of either inser or delete to a binary tree
 * instructions: ex. input of [40,45,d45,D20,50] will insert 40 then insert 45 then delete 45 then delete 20 then add 50.
 */
/**
 *
 * @author Reem AlGhamdi
 * @date 5/21/2018
 */
package prog1;

public class Tree {
 public Node root;

 
 public Tree(){  
   root=null;
  }
 
public void insert(int input){

Node newNode=new Node(input);  // create node
if (root==null) //if tree empty insert in the root
{root=newNode;}
else {
Node current = root;
Node parent;
while (current!=null)
{
parent = current;

if(input < current.num()) //left
{current = current.left();
if(current == null)
{
parent.left(newNode);
}
}
else //right 
{current = current.right();
if(current==null)
{parent.right(newNode);}
}
}
}
}

public  void prt(Node node) {
    if(node==null){
    }
    else{
    System.out.print(" ");
    prt(node.left());
    prt(node.right());
    System.out.println(node.num() + " ");
    }                 
                
}
//In order
     public void inOrder(Node myNode){
     if(myNode!= null){
     inOrder(myNode.left());
     
     System.out.print(myNode.num()+ " ");
     inOrder(myNode.right());
     
     }}
   //postOrder
     public void postOrder(Node myNode){
     if(myNode==null)
     return;
     postOrder(myNode.left());
     postOrder(myNode.right());
     System.out.print(myNode.num()+ " ");
     }
   //pre-order
     public void preOrder(Node myNode){
         if(myNode==null)
             return;
         System.out.print(myNode.num()+ " ");
         preOrder(myNode.left());
         preOrder(myNode.right());
     }
     public void print(Node x,int s){
     if (x==null)   
         return;
     print(x.right(),s+8);
     System.out.println(String.format("%1$"+(s)+"s", "")+"|---("+x.num()+")|");
     print(x.left(),s+8);
     }
     
    public Node find(int key) 
    {   
    Node current=root;
    while (current.num()!=key)
    {
    if(key<current.num())
    {
     current =current.left();
    }
    else{
    current=current.right();
    }
    
     if(current==null){
      System.out.println(key + " could not be found");
      return null;
    }
    }
    return current;
    }
    
    public boolean delete(int delete)
    {
     Node key = find(delete);
     Node parent = findp(delete);
     if(key==null)
     {  
         System.out.println(delete + " Could not be deleted");
         return false;
     }
     
    //no children  #####################
    if(key.left()==null && key.right()==null)
    {
    if(key==root) // if only root exist
    {root=null;
    System.out.println("Tree is empty now!");
    }
    else{
        if(parent.left() == key){
        parent.left(null);
        } else {
        parent.right(null);
        }
    }
    }
    // 2 child ########################
    else if (key.left() != null && key.right()!= null){  // TO DO: root case 
     Node suc = suc(key);   
     Node sucp = findp(suc.num());
     int sucnum = suc.num();
     
     if (key == root){
       if(suc==root.right())
       { root=root.right();}
     }
     if(suc == key.right()){  // case when the suc is the right child of the key 
       delete(suc.num()); 
         key.num(sucnum);
     }
     else if(suc.right()!=null){ // there is right child
     sucp.left(suc.right()); // step one
     suc.right(key.right()); // step two
     suc.left(key.left());   // step three
     key.num(sucnum);        // step four
     } else { // no child 
     delete(suc.num()); // delete suc 
     key.num(sucnum); // set new num instead of delete
     }
    }
    
    // 1 child ########################
    else if (key.left() != null || key.right()!= null){
    // key has LEFT CHILD    
    if (key.left()!=null){
        if(key == root){
        root = key.left();
        } else { // not root child
            
        if(parent.left() == key){
        parent.left(key.left());
        } else if(parent.right() == key){ // its on the right
        parent.right(key.left());
        }
        
        }
    } 
    else { // key has RIGHT CHILD    
        if(key == root){
        root = key.right();
        } else { // not root child
        if(parent.left() == key){
        parent.left(key.right());
        } else if(parent.right() == key){ // its on the right
        parent.right(key.right());
        }
        }
    }
    }
    
    else {
        System.out.println("ERRRORORORR ");
    }
 return true;
}
      
public Node findp(int key) 
    {   
    Node current=root;
    Node parent = root;
    while (current.num()!=key)
    {
    if(key<current.num())
    {
     parent = current;
     current =current.left();
    }
    else{
    parent = current;
    current=current.right();
    }
    
     if(current==null){
     System.out.println(key + " could not be found");
      return null;
    }
    
    }
    return parent;
    }    
    public Node suc(Node k)
    {
    Node suc = k.right();
    while(suc.left()!=null){
    suc = suc.left();
    }
    suc=k.right();
    return suc;
    
   
    
}}