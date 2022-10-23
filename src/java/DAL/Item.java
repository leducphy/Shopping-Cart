/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author leducphi
 */
public class Item {

    private Product product;
    private int Quantity;
    private double UnitPrice;

    public Item() {
    }

    public Item(Product product, int Quantity, double UnitPrice) {
        this.product = product;
        this.Quantity = Quantity;
        this.UnitPrice = UnitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    @Override
    public String toString() {
        return "Item{" + "product=" + product + ", Quantity=" + Quantity + ", UnitPrice=" + UnitPrice + '}';
    }

}
