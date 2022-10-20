/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import DAL.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leducphi
 */
public class OrderDAO extends DBContext {

    public void addOrder(Customers cus, Cart cart) {
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
                    + "(   N'?',       -- CustomerID - nchar(5)\n"
                    + "    ?,         -- EmployeeID - int\n"
                    + "    GETDATE(), -- OrderDate - datetime\n"
                    + "    GETDATE(), -- RequiredDate - datetime\n"
                    + "    GETDATE(), -- ShippedDate - datetime\n"
                    + "    ?,      -- Freight - money\n"
                    + "    N'?',       -- ShipName - nvarchar(40)\n"
                    + "    N'?',       -- ShipAddress - nvarchar(60)\n"
                    + "    N'?',       -- ShipCity - nvarchar(15)\n"
                    + "    N'?',       -- ShipRegion - nvarchar(15)\n"
                    + "    N'?',       -- ShipPostalCode - nvarchar(10)\n"
                    + "    N'?'        -- ShipCountry - nvarchar(15)\n"
                    + "    )";

            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, cus.getCustomerID());
            ps1.setInt(2, 7);
            ps1.setDouble(3, 12.5);
            ps1.setString(4, cus.getContactName());
            ps1.setString(5, cus.getAddress());
            ps1.setString(6, cus.getAddress());
            ps1.setString(7, cus.getAddress());
            ps1.setString(8, cus.getAddress());
            ps1.setString(9, cus.getAddress());
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
}
