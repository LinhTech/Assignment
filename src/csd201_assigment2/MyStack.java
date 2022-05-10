package csd201_assigment2;
import java.util.EmptyStackException;
/**
*Class cai dat va quan ly Stack trong chuong trinh
*/
public class MyStack {
    private Node head;
    
    public MyStack() {
        this.head = null;
    }
    public boolean isEmpty(){ 
        return(head==null);
    }
    public void push(Product x) {
        head = new Node(x, head);
    }
    public Product pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        Product x = head.getProduct();
        head = head.getNextNode();
        return x;
    }
    public void displayStack() {
        System.out.println("Pcode | Pname | Price($) | Quantity | Unit ");
        while (!isEmpty()) {
            System.out.println(pop().toString());
        }
        System.out.println();
    }
}
