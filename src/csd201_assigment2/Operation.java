package csd201_assigment2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Scanner;

/**
 *Class bao gom phuong thuc thuc hien cac chuc nang cua chuong trinh
 */
public class Operation {   
    public static LinkedList productList = new LinkedList(); //Danh sach lien ket de thuc hien trong chuong trinh
    public static MyStack myStack = new MyStack();
    public static MyQueue myQueue = new MyQueue();
    public static void getFromFileToList() {
        //Khoi tao lai danh sach
        productList.head = null;
        productList.tail = null;
        String line = "";
        try {
            FileReader file = new FileReader("C:/Users/Admin/NetBeans/CSD201_Assigment2/ProductList.TXT");
            BufferedReader input = new BufferedReader(file);
            
            line = input.readLine(); //Doc truoc 1 dong de bo qua dong tieu de
            while ((line = input.readLine()) != null) { //Doc file theo tung dong
                String[] content = line.split(" | ");
                String productCode = content[0];              
                String productName = content[2];              
                double price = Double.parseDouble(content[4]);
                int quantity = Integer.parseInt(content[6]);
                String unit = content[8];
                Product product = new Product(productCode, productName, price, quantity, unit);
                productList.addAtTail(product);
            }
            input.close();
            file.close();
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        productList.displayList();
    }
    public static void inputAndAdd() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input information of new product: ");
        System.out.print("Product Code: "); 
        String productCode = sc.next();
        System.out.print("Product Name: "); 
        String productName = sc.next();      
        System.out.print("Product Price: "); 
        double price = sc.nextDouble();
        System.out.print("Quantity: "); 
        int quantity = sc.nextInt();
        System.out.print("Unit: "); 
        String unit = sc.next();
        Product product = new Product(productCode, productName, price, quantity, unit);      
        productList.addAtTail(product);
        
    }
    public static void displayList() {
        productList.displayList();
    }
    public static void saveFromListToFile() {
        
        try {
            FileWriter file = new FileWriter("C:/Users/Admin/NetBeans/CSD201_Assigment2/ProductList.TXT", false);
            BufferedWriter output = new BufferedWriter(file);
            String title = "Pcode | Pname | Price($) | Quantity | Unit ";
            output.write(title);
            output.newLine();
            Node current = productList.head;
            while (current != null) {
                output.write(current.getProduct().toString());
                output.newLine();
                current = current.getNextNode();
            }
            output.close();
            file.close();
            
        } catch (Exception e) {
        }
    }
    public static void findByProductCode(String id) {
           
        Node current = productList.head;
        while (current != null) {
            if (current.getProduct().getProductCode().equals(id)) {
                current.getProduct().display();
                return;
            }
            current = current.getNextNode();
        }
        System.out.println("-1");
    }
    /*
    * Phuong thuc chuyen so luong thanh nhi phan bang de quy
    */
    public static String convertToBinary(int a) {
        if (a / 2 == 0) { //dieu kien ket thuc de quy 
            return "" + 1;
        }
        return "" + convertToBinary(a/2) + a%2;
    }
    public static void deleteById(String id) {
        Node preNode = null;
        Node current = productList.head;
        while (current != null) {
        //San pham can xoa nam o dau danh sach
        if (productList.head.getProduct().getProductCode().equals(id)) {
            productList.head = productList.head.getNextNode();
        //San pham can xoa nam o cuoi danh sach
        } else if (current.getProduct().getProductCode().equals(id) && current.getNextNode() == null) {
            current.setNextNode(null);
            productList.tail = preNode;    
        //San pham can xoa nam o giua danh sach
        } else if (current.getProduct().getProductCode().equals(id)) {
            preNode.setNextNode(current.getNextNode());
        }
        preNode = current;
        current = current.getNextNode();
        }
        System.out.println("successed!");
    }
    public static void quickSort(LinkedList l) {
        LinkedList l1 = new LinkedList(); //danh sach phu co id nho hon tag
        LinkedList l2 = new LinkedList(); //danh sach phu co id lon hon tag
        Node tag, p; //Bien node de tach ra lam phan tu so sanh
        if (l.head == l.tail) {
            return;
        }
        tag = l.head; //gia tri chot de phan vung 
        l.head = l.head.getNextNode();
        tag.setNextNode(null); //co lap gia tri chot
        while (l.head != null) {
            p = l.head;
            l.head = l.head.getNextNode();
            p.setNextNode(null);
            //So sanh 2 id
            if (p.getProduct().getProductCode().compareToIgnoreCase(tag.getProduct().getProductCode()) < 0) {
                l1.addAtHead(p.getProduct());      
            } else {
                l2.addAtHead(p.getProduct());
            }
        }
        //Goi de quy de sap xep 2 danh sach phu l1 va l2
        quickSort(l1);
        quickSort(l2);
        //Thuc hien noi l1 voi l2 sau khi da sap xep de tao ra danh sach l
        if (l1.head != null) { // Kiem tra l1 co rong hay khong
            l.head = l1.head;
            l1.tail.setNextNode(tag);
        } else {
            l.head = tag;
        }
        tag.setNextNode(l2.head);
        if (l2.head != null) { //Kiem tra l2 co rong hay khong
            l.tail = l2.tail;
        } else {
            l.tail = tag;
        }
    }
    public static void saveToStackAndDislay() {
        String line = "";
        try {
            FileReader file = new FileReader("C:/Users/Admin/NetBeans/CSD201_Assigment2/ProductList.TXT");
            BufferedReader input = new BufferedReader(file);
            
            line = input.readLine(); //Doc truoc 1 dong de bo qua dong tieu de
            while ((line = input.readLine()) != null) { //Doc file theo tung dong
                String[] content = line.split(" | ");
                String productCode = content[0];              
                String productName = content[2];              
                double price = Double.parseDouble(content[4]);
                int quantity = Integer.parseInt(content[6]);
                String unit = content[8];
                Product product = new Product(productCode, productName, price, quantity, unit);
                myStack.push(product);
            }
            input.close();
            file.close();
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        myStack.displayStack();
    }
    public static void saveToQueueAndDislay() throws Exception {      
        String line = "";
        try {
            FileReader file = new FileReader("C:/Users/Admin/NetBeans/CSD201_Assigment2/ProductList.TXT");
            BufferedReader input = new BufferedReader(file);
            
            line = input.readLine(); //Doc truoc 1 dong de bo qua dong tieu de
            while ((line = input.readLine()) != null) { //Doc file theo tung dong
                String[] content = line.split(" | ");
                String productCode = content[0];              
                String productName = content[2];              
                double price = Double.parseDouble(content[4]);
                int quantity = Integer.parseInt(content[6]);
                String unit = content[8];
                Product product = new Product(productCode, productName, price, quantity, unit);
                myQueue.enqueue(product);
            }
            input.close();
            file.close();
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        myQueue.displayQueue();
    }
}
