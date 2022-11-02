/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import DAL.Customers;
import DAL.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leducphi
 */
public class CustomerDAO extends DBContext {

    public Customers getProfile(int ID) {
        Customers cus = null;
        try {
            String sql = "select * from Customers c, Accounts a where c.CustomerID = a.CustomerID and a.AccountID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String CustomerID = rs.getString("CustomerID");
                String CompanyName = rs.getString("CompanyName");
                String ContactName = rs.getString("ContactName");
                String ContactTitle = rs.getString("ContactTitle");
                String Address = rs.getString("Address");
                String Role = rs.getString("Role");
                String Email = rs.getString("Email");
                cus = new Customers(CustomerID, CompanyName, ContactName, ContactTitle, Address, Role, Email);

            }
        } catch (SQLException e) {
        }
        return cus;
    }

    public Customers getCustomersByID(String ID) {
        Customers cus = null;
        try {
            String sql = "SELECT * FROM dbo.Customers WHERE CustomerID = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String CompanyName = rs.getString("CompanyName");
                String ContactName = rs.getString("ContactName");
                String ContactTitle = rs.getString("ContactTitle");
                String Address = rs.getString("Address");
                
                cus = new Customers(ID, CompanyName, ContactName, ContactTitle, Address, null, null);

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return cus;
    }

    public void updateProfile(String cusID, String CompanyName, String ContactName, String ContactTitle, String Address) {
        try {
            String sql = "UPDATE [dbo].[Customers]\n"
                    + "SET [CompanyName] = ?,\n"
                    + "    [ContactName] = ?,\n"
                    + "    [ContactTitle] = ?,\n"
                    + "    [Address] = ?\n"
                    + "WHERE CustomerID = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, CompanyName);
            ps.setString(2, ContactName);
            ps.setString(3, ContactTitle);
            ps.setString(4, Address);
            ps.setString(5, cusID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
        public void addCustomer(String CusID, String CompanyName, String ContactName, String ContactTitle, String Address) {
        try {
            String sql = "INSERT INTO Customers"
                    + "  (CustomerID, CompanyName, ContactName, ContactTitle, Address) VALUES "
                    + " (?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, CusID);
            ps.setString(2, CompanyName);
            ps.setString(3, ContactName);
            ps.setString(4, ContactTitle);
            ps.setString(5, Address);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public static void main(String[] args) {
        new CustomerDAO().updateProfile("GUEST", "12g", "g", "x", "x");
        System.out.println(new CustomerDAO().getCustomersByID("AWMAA"));
    }
}
