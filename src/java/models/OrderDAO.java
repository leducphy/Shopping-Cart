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
 * @author leducphi
 */
public class OrderDAO extends DBContext {

    public void addOrder(Customers cus, Cart cart, String RequiedDate) {
        try {
            String sql1 = "INSERT INTO dbo.Orders\n"
                    + "(\n"
                    + "    CustomerID,\n"
                    + "    EmployeeID,\n"
                    + "    OrderDate,\n"
                    + "    RequiredDate,\n"
                    + "    ShippedDate,\n"
                    + "    Freight,\n"
                    + "    ShipName,\n"
                    + "    ShipAddress,\n"
                    + "    ShipCity,\n"
                    + "    ShipRegion,\n"
                    + "    ShipPostalCode,\n"
                    + "    ShipCountry\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(   ?,       -- CustomerID - nchar(5)\n"
                    + "    NULL,         -- EmployeeID - int\n"
                    + "    GETDATE(), -- OrderDate - datetime\n"
                    + "    ?, -- RequiredDate - datetime\n"
                    + "    NULL, -- ShippedDate - datetime\n"
                    + "    NULL,      -- Freight - money\n"
                    + "    ?,       -- ShipName - nvarchar(40)\n"
                    + "    ?,       -- ShipAddress - nvarchar(60)\n"
                    + "    NULL,       -- ShipCity - nvarchar(15)\n"
                    + "    NULL,       -- ShipRegion - nvarchar(15)\n"
                    + "    NULL,       -- ShipPostalCode - nvarchar(10)\n"
                    + "    NULL        -- ShipCountry - nvarchar(15)\n"
                    + "    )";

            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, cus.getCustomerID());
            ps1.setString(2, RequiedDate);
            ps1.setString(3, cus.getContactName());
            ps1.setString(4, cus.getAddress());

            ps1.executeUpdate();

            //lay ra orderID cua sql1 vua add
            String sql2 = "SELECT TOP 1\n"
                    + "       OrderID\n"
                    + "FROM dbo.Orders\n"
                    + "ORDER BY OrderID DESC;";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ResultSet rs = ps2.executeQuery();

            //add vao bang order details
            while (rs.next()) {
                int orderID = rs.getInt("OrderID");
                for (Item i : cart.getItems()) {
                    String sql3 = "INSERT INTO dbo.[Order Details]\n"
                            + "(\n"
                            + "    OrderID,\n"
                            + "    ProductID,\n"
                            + "    UnitPrice,\n"
                            + "    Quantity,\n"
                            + "    Discount\n"
                            + ")\n"
                            + "VALUES\n"
                            + "(   ?,    -- OrderID - int\n"
                            + "    ?,    -- ProductID - int\n"
                            + "    ?, -- UnitPrice - money\n"
                            + "    ?,    -- Quantity - smallint\n"
                            + "    ?   -- Discount - real\n"
                            + "    );";
                    PreparedStatement ps3 = connection.prepareStatement(sql3);
                    ps3.setInt(1, orderID);
                    ps3.setInt(2, i.getProduct().getProductID());
                    ps3.setDouble(3, i.getUnitPrice());
                    ps3.setInt(4, i.getQuantity());
                    ps3.setDouble(5, 0.0);
                    ps3.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<OrderDetailsDTO> getListOrderByCusID(String cid) {
        ArrayList<OrderDetailsDTO> li = new ArrayList<>();
        try {
            String sql = "SELECT *\n"
                    + "FROM Orders\n"
                    + "WHERE CustomerID = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                int ProductID = 0;
                double UnitPrice = 0;
                int Quantity = 0;
                String CustomerID = rs.getString("CustomerID");
                String OrderDate = rs.getString("OrderDate");
                String RequiredDate = rs.getString("RequiredDate");
                String ShipName = rs.getString("ShipName");
                String ShipAddres = rs.getString("ShipAddress");
                li.add(new OrderDetailsDTO(OrderID, ProductID, UnitPrice, Quantity, CustomerID, OrderDate, RequiredDate, ShipName, ShipAddres));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return li;
    }

    public ArrayList<OrderDetailsDTO> getListOrderDetailByOID(ArrayList<OrderDetailsDTO> lobid) {
        ArrayList<OrderDetailsDTO> li = new ArrayList<>();
        try {
            String sql = "SELECT *\n"
                    + "FROM dbo.[Order Details]\n"
                    + "WHERE OrderID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            for (OrderDetailsDTO o : lobid) {
                ps.setInt(1, o.getOrderID());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int OrderID = rs.getInt("OrderID");
                    int ProductID = rs.getInt("ProductID");
                    double UnitPrice = rs.getDouble("UnitPrice");
                    int Quantity = rs.getInt("Quantity");
                    String CustomerID = null;
                    String OrderDate = null;
                    String RequiredDate = null;
                    String ShipName = null;
                    String ShipAddres = null;
                    li.add(new OrderDetailsDTO(OrderID, ProductID, UnitPrice, Quantity, CustomerID, OrderDate, RequiredDate, ShipName, ShipAddres));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return li;
    }


}
