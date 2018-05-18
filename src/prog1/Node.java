
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
public class Node {
private  Node left; 
private Node right; 
private int num; 

public Node(int n)
{
num=n;
left=null;
right=null;

}
public Node left()
{

return left;
}

public void left(Node inputNode)
{
  left= inputNode;
  
}

public Node right()
{

return right;
}

public void right(Node inputNode)
{
  right= inputNode;
}
public int num()
{
return num;
}

public void num(int x){
num = x;
}


}



