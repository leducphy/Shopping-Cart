/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import models.ProductDAO;

/**
 *
 * @author leducphi
 */
public class OrderDetailsDTO {

    private int OrderID;
    private int ProductID;
    private double UnitPrice;
    private int Quantity;
    private String CustomerID;
    private String OrderDate;
    private String RequiredDate;
    private String ShipName;
    private String ShipAddres;

    public OrderDetailsDTO(int OrderID, int ProductID, double UnitPrice, int Quantity, String CustomerID, String OrderDate, String RequiredDate, String ShipName, String ShipAddres) {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
        this.CustomerID = CustomerID;
        this.OrderDate = OrderDate;
        this.RequiredDate = RequiredDate;
        this.ShipName = ShipName;
        this.ShipAddres = ShipAddres;
    }

    public OrderDetailsDTO() {
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(String RequiredDate) {
        this.RequiredDate = RequiredDate;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String ShipName) {
        this.ShipName = ShipName;
    }

    public String getShipAddres() {
        return ShipAddres;
    }

    public void setShipAddres(String ShipAddres) {
        this.ShipAddres = ShipAddres;
    }

    public String getProductName() {
        return new ProductDAO().getProductByID(ProductID).getProductName();
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" + "OrderID=" + OrderID + ", ProductID=" + ProductID + ", UnitPrice=" + UnitPrice + ", Quantity=" + Quantity + ", CustomerID=" + CustomerID + ", OrderDate=" + OrderDate + ", RequiredDate=" + RequiredDate + ", ShipName=" + ShipName + ", ShipAddres=" + ShipAddres + '}';
    }
}
