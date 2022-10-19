/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import DAL.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "Select * From Products";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (SQLException e) {
        }
        return products;
    }

    public ArrayList<Product> getHotProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT TOP 4\n"
                    + "       *\n"
                    + "FROM dbo.[Order Details] o,\n"
                    + "     dbo.Products p\n"
                    + "WHERE o.ProductID = p.ProductID\n"
                    + "ORDER BY Discount DESC;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (SQLException e) {
        }
        return products;
    }

    public ArrayList<Product> getBestSaleProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT TOP 4\n"
                    + "       *\n"
                    + "FROM dbo.[Order Details] o,\n"
                    + "     dbo.Products p\n"
                    + "WHERE o.ProductID = p.ProductID\n"
                    + "ORDER BY Discount ASC;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (SQLException e) {
        }
        return products;
    }

    public ArrayList<Product> getNEWProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT TOP 4\n"
                    + "       *\n"
                    + "FROM dbo.Products p,\n"
                    + "     dbo.[Order Details] o\n"
                    + "WHERE p.ProductID = o.ProductID\n"
                    + "ORDER BY p.UnitsInStock DESC;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (SQLException e) {
        }
        return products;
    }

    public ArrayList<Product> getProductsByPage(int page, int elements) {
        ArrayList<Product> products = new ArrayList<>();
        int start = page * elements - elements;
        try {
            String sql = "SELECT *FROM products\n"
                    + "ORDER BY\n"
                    + "   ProductID\n"
                    + "OFFSET ? ROWS \n"
                    + "FETCH NEXT ? ROWS ONLY;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, elements);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                p.setUnitPrice(rs.getDouble("UnitPrice"));
                p.setUnitsInStock(rs.getInt("UnitsInStock"));
                p.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
                p.setReorderLevel(rs.getInt("ReorderLevel"));
                p.setDiscontinued(rs.getBoolean("Discontinued"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

//    public static void main(String[] args) {
//        ArrayList<Product> list = new ProductDAO().getHotProducts();
//        for (Product item : list) {
//            System.out.println(item.toString());
//        }
//    }
}
