package csd201_assigment2;
import static csd201_assigment2.Operation.productList;
/**
 *Class cai dat va quan ly danh sach lien ket trong chuong trinh
 */
public class LinkedList {
    Node head;
    Node tail;


    public LinkedList() {}

    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
    public void addAtHead(Product product) {
        Node newNode = new Node(product);
        
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        newNode.setNextNode(this.head);
        this.head = newNode;
    }
    public void addAtTail(Product product) {
        Node newNode = new Node(product);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        this.tail.setNextNode(newNode);
        this.tail = newNode;   

    }
    public void displayList() {
        System.out.println("Pcode | Pname | Price($) | Quantity | Unit ");
        Node current = productList.head;
        while (current != null) {
            System.out.println(current.getProduct().toString());
            current = current.getNextNode();
        }     
    }

    public Node searchById(String id) {
            Node current = productList.head;
            while (current != null) {
                if (current.getProduct().getProductCode().equals(id)) {
                    return current;
                }
                current = current.getNextNode();
            }
            return null;
        }
}