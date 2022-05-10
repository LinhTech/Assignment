/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csd201_assigment2;
/**
*Class cai dat va quan ly Queue trong chuong trinh
*/
public class MyQueue {
    Node head, tail;
    
    public MyQueue() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return (head==null);
    }
    public void enqueue(Product product) {
        if (isEmpty()) {
            head = tail = new Node(product);
        } else {
            tail.setNextNode(new Node(product));
            tail = tail.getNextNode();
        }
    }
    public Product dequeue() throws Exception {
        if (isEmpty()) throw new Exception();
        Product x = head.getProduct();
        head = head.getNextNode();
        if (head == null) {
            tail = null;
        }
        return x;
    }
    public void displayQueue() throws Exception {
        System.out.println("Pcode | Pname | Price($) | Quantity | Unit ");
        while (!isEmpty()) {
            System.out.println(dequeue().toString());
        }
        System.out.println();
    }
}
