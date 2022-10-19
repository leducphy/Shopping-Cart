/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import DAL.Account;
import DAL.Customers;
import DAL.DBContext;
import DAL.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author leducphi
 */
public class AccountDAO extends DBContext {

    public Account getAccount(String email, String pass) {
        Account account = null;
        try {
            String sql = "select * from Accounts where Email=? and Password=?";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            //Step 3: thuc thti truy van
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");
                account = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role);
            }
        } catch (SQLException e) {
        }

        return account;
    }

    public int AddAccount(Account acc, Customers cus) {
        int result1 = 0, result2 = 0;

        try {
            String sql1 = "insert into Customers(CustomerID, CompanyName,ContactName, ContactTitle, Address) values(?,?,?,?,?)";
            String sql2 = "insert into Accounts(Email, Password, CustomerID, Role) values (?,?,?,2)";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, cus.getCustomerID());
            ps1.setString(2, cus.getCompanyName());
            ps1.setString(3, cus.getContactName());
            ps1.setString(4, cus.getContactTitle());
            ps1.setString(5, cus.getAddress());
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setString(1, acc.getEmail());
            ps2.setString(2, acc.getPassword());
            ps2.setString(3, cus.getCustomerID());
            result1 = ps1.executeUpdate();
            result2 = ps2.executeUpdate();
        } catch (SQLException e) {
        }
        if (result1 != 0 && result2 != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            String sql = "Select * From Accounts";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("Email");
                accounts.add(new Account(0, email, "", "", 0, 0));
            }
        } catch (SQLException e) {
        }
        return accounts;
    }

    public static void main(String[] args) {
        ArrayList<Account> list = new AccountDAO().getAccounts();
        for (Account item : list) {
            System.out.println(item.toString());
        }
    }
}
