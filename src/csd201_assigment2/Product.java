package csd201_assigment2;
/**
 * Class quan ly san pham: ma id, ten, gia, so luong
 */
public class Product {
    private String productCode;
    private String productName;
    private double productPrice;
    private int quantity;
    private String unit;
    
    public Product() {};
    public Product(String productCode, String productName, double productPrice, 
            int quantity, String unit) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getProductCode() {
        return productCode;
    }
    public int getQuantity() {
        return quantity;
    }
    public void display() {
        System.out.println("[Product code: " + this.productCode + ", Name of product: " + this.productName + 
                ", Price: " + this.productPrice + ", Quantity: " + this.quantity + 
                ", Unit: " + unit + "]");
    }
    @Override
    public String toString() {
        return this.productCode + " | " + this.productName + 
                " | " + this.productPrice + " | " + this.quantity + 
                " | " + this.unit;
    }
}