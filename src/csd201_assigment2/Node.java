package csd201_assigment2;
/**
 * Class quan ly Node
 */
public class Node {
    private Product product = new Product();
    private Node nextNode;
    
    public Node(Product product, Node node) {
        this.product = product;
        this.nextNode = node;
    }
    public Node(Product product) {
        this.product = product;
    }
    
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
    public Node getNextNode() {
        return this.nextNode;
    }
    
}
