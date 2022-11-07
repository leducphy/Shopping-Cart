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

    public Product getProductByID(int ID) {
        Product product = null;
        try {
            String sql = "SELECT p.ProductID,\n"
                    + "       p.ProductName,\n"
                    + "       p.CategoryID,\n"
                    + "       p.QuantityPerUnit,\n"
                    + "       p.UnitPrice,\n"
                    + "       p.UnitsInStock,\n"
                    + "       p.UnitsOnOrder,\n"
                    + "       p.ReorderLevel,\n"
                    + "       p.Discontinued 	\n"
                    + "FROM products p\n"
                    + "WHERE p.ProductID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ID);
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
                product = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
            }
        } catch (SQLException e) {
        }
        return product;
    }

    public ArrayList<Product> getHotProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT TOP 4\n"
                    + "       *\n"
                    + "FROM [Order Details] od\n"
                    + "    INNER JOIN Products p\n"
                    + "        ON p.ProductID = od.ProductID\n"
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
                    + "FROM [Order Details] od\n"
                    + "    INNER JOIN Products p\n"
                    + "        ON p.ProductID = od.ProductID\n"
                    + "ORDER BY UnitsOnOrder DESC;";
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
                    + "FROM Products\n"
                    + "ORDER BY ProductID DESC;";
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
        } catch (SQLException e) {
        }
        return products;
    }

    public ArrayList<Product> getProductsByIDAndPage(int page, int elements, int id) {
        ArrayList<Product> products = new ArrayList<>();
        int start = page * elements - elements;
        try {
            String sql = "SELECT p.ProductID,\n"
                    + "       p.ProductName,\n"
                    + "       p.CategoryID,\n"
                    + "       p.QuantityPerUnit,\n"
                    + "       p.UnitPrice,\n"
                    + "       p.UnitsInStock,\n"
                    + "       p.UnitsOnOrder,\n"
                    + "       p.ReorderLevel,\n"
                    + "       p.Discontinued 	\n"
                    + "FROM products p, dbo.Categories c\n"
                    + "WHERE c.CategoryID = p.CategoryID\n"
                    + "AND p.CategoryID = ?\n"
                    + "\n"
                    + "ORDER BY ProductID OFFSET ? \n"
                    + "ROWS FETCH NEXT ? ROWS ONLY;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, start);
            ps.setInt(3, elements);
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
        } catch (SQLException e) {
        }
        return products;
    }

    public ArrayList<Product> getProductsByCatID(int id) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.ProductID,\n"
                    + "       p.ProductName,\n"
                    + "       p.CategoryID,\n"
                    + "       p.QuantityPerUnit,\n"
                    + "       p.UnitPrice,\n"
                    + "       p.UnitsInStock,\n"
                    + "       p.UnitsOnOrder,\n"
                    + "       p.ReorderLevel,\n"
                    + "       p.Discontinued 	\n"
                    + "FROM products p, dbo.Categories c\n"
                    + "WHERE c.CategoryID = p.CategoryID\n"
                    + "AND p.CategoryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
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
        } catch (SQLException e) {
        }
        return products;
    }

    public ArrayList<Product> searchProductName(String name) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.Products WHERE ProductName LIKE '%" + name + "%'";
            PreparedStatement ps = connection.prepareStatement(sql);
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
        } catch (SQLException e) {
        }
        return products;
    }

    public ArrayList<Product> searchProductNameAndCatID(String name, int CatID) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.Products WHERE ProductName LIKE '%" + name + "%'" + "and CategoryID = " + CatID;
            PreparedStatement ps = connection.prepareStatement(sql);
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
        } catch (SQLException e) {
        }
        return products;
    }

    public void DeleteProduct(int id) {
        String sql = "DELETE FROM dbo.[Order Details] WHERE ProductID = ?\n"
                + "DELETE FROM dbo.Products WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int addProduct(Product p) {
        int r = 0;
        try {
            String sql = "INSERT INTO dbo.Products\n"
                    + "(\n"
                    + "    ProductName,\n"
                    + "    CategoryID,\n"
                    + "    QuantityPerUnit,\n"
                    + "    UnitPrice,\n"
                    + "    UnitsInStock,\n"
                    + "    UnitsOnOrder,\n"
                    + "    ReorderLevel,\n"
                    + "    Discontinued\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(   ?,  -- ProductName - nvarchar(40)\n"
                    + "    ?,    -- CategoryID - int\n"
                    + "    ?,  -- QuantityPerUnit - nvarchar(20)\n"
                    + "    ?, -- UnitPrice - money\n"
                    + "    ?,    -- UnitsInStock - smallint\n"
                    + "    ?,    -- UnitsOnOrder - smallint\n"
                    + "    ?,    -- ReorderLevel - smallint\n"
                    + "    ?  -- Discontinued - bit\n"
                    + "    )";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setInt(2, p.getCategoryID());
            ps.setString(3, p.getQuantityPerUnit());
            ps.setDouble(4, p.getUnitPrice());
            ps.setInt(5, p.getUnitsInStock());
            ps.setInt(6, p.getUnitsOnOrder());
            ps.setInt(7, p.getReorderLevel());
            ps.setBoolean(8, p.isDiscontinued());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (r != 0) {
            return 1;
        } else {
            return 0;
        }

    }

    public int updateProduct(Product p) {
        int result = 0;
        try {
            String sql = "UPDATE Products\n"
                    + "SET ProductName = ?,\n"
                    + "    CategoryID = ?,\n"
                    + "    QuantityPerUnit = ?,\n"
                    + "    UnitPrice = ?,\n"
                    + "    UnitsInStock = ?,\n"
                    + "    UnitsOnOrder = ?,\n"
                    + "    ReorderLevel = ?,\n"
                    + "    Discontinued = ?\n"
                    + "WHERE ProductID = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setString(2, String.valueOf(p.getCategoryID()));
            ps.setString(3, p.getQuantityPerUnit());
            ps.setString(4, String.valueOf(p.getUnitPrice()));
            ps.setString(5, String.valueOf(p.getUnitsInStock()));
            ps.setString(6, String.valueOf(p.getUnitsOnOrder()));
            ps.setString(7, String.valueOf(p.getReorderLevel()));
            ps.setString(8, String.valueOf(p.isDiscontinued()));
            ps.setString(9, String.valueOf(p.getProductID()));

            result = ps.executeUpdate();
        } catch (Exception e) {
        }
        if (result != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

        ArrayList<Product> li = dao.searchProductNameAndCatID("a", 3);
        for (Product x : li) {
            System.out.println(x);
        }
    }
}
