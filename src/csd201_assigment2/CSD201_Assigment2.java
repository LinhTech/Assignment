
package csd201_assigment2;
import java.util.Scanner;
public class CSD201_Assigment2 {

    /**
     * Class chua phuong thuc main dieu huong chuong trinh
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);                  
        int choose; // Bien de lua chon chuc nang
    // Vong lap ua chon chuc nang cua chuong trinh
        do {
            System.out.println("MENU: ");   
            System.out.println("""
                               1. Load data from file and display
                               2. Input & add to the end
                               3. Display data
                               4. Save product list to file
                               5. Search by ID
                               6. Delete by ID
                               7. Sort by ID
                               8. Convert to Binary
                               9. Load to stack and display
                               10. Load to queue and display
                               0. Exit""");
            choose = sc.nextInt();
            sc.nextLine();
            if (choose == 1) {
                Operation.getFromFileToList();
            }
            else if (choose == 2) {
                Operation.inputAndAdd();
                System.out.println("successed!");
            }
            else if (choose == 3) {
                Operation.displayList();
            }
            else if (choose == 4) {
                Operation.saveFromListToFile();
                System.out.println("successed!");
            } else if (choose == 5) {              
                System.out.print("Input ID: ");
                String id = sc.nextLine();
                Operation.findByProductCode(id);
            } else if (choose == 6) {
                System.out.print("Input ID to delete: ");
                String id = sc.nextLine();
                Operation.deleteById(id);              
            } else if (choose == 7) {
                //Operation.sortListById();
                Operation.quickSort(Operation.productList);
                System.out.println("successed!");
            } else if (choose == 8) {
                System.out.println(Operation.productList.head.getProduct().toString());
                System.out.println("Quantity to binary: " + 
                        Operation.convertToBinary(Operation.productList.head.getProduct().getQuantity()));
            } else if (choose == 9) {
                Operation.saveToStackAndDislay();
            } else if (choose == 10) {
                Operation.saveToQueueAndDislay();
            }
            
        }
        while (choose != 0); //Kiem tra dieu kien vong lap
        System.out.println("Thanks!");
    }
    
    
}
