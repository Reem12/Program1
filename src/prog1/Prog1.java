
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


import java.util.*;
import java.io.*;

public class Prog1 {

public static String [] s2;

private Scanner x;

public void open(){
     try{
         x = new Scanner(new File("input.txt"));
     }
     catch(Exception e){
     System.out.println("Could not find file");
     }

}
//read file 
public void read(){
String s = "";
while(x.hasNext()){
s = s + x.next() +",";
}

 s2 = s.split(","); // split by spaces
System.out.println("input: ");
    for (int i = 0; i < s2.length; i++){
      System.out.print(s2[i]+" ");    
    }
       System.out.println();    
       System.out.println("--------------------------------------");

}

    public static void main(String[] args) {
     Prog1 r = new Prog1();
     r.open();
     r.read();
     Tree t = new Tree();
     
    // excute commands
    for (int i = 0; i < s2.length; i++){
        
       if(s2[i].charAt(0) == 'd' || s2[i].charAt(0) == 'D') {
       s2[i] = s2[i].substring(1);
       t.delete(Integer.valueOf(s2[i]));
       t.print(t.root, 1);
              System.out.println("--------------------------------------");

       }
       else{
       t.insert(Integer.valueOf(s2[i]));
       t.print(t.root, 1);
       System.out.println("--------------------------------------");

       }
    }
    

    System.out.print("Post-order: ");
    t.postOrder(t.root);
    System.out.println("\n--------------------------------------");
    System.out.print("Pre-order:  ");

    t.preOrder(t.root);
           System.out.println("\n--------------------------------------");
    System.out.print("In-order:   ");

    t.inOrder(t.root);
           System.out.println("\n--------------------------------------");


    }
    
}
