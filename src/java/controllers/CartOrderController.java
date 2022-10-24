/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.*;
import models.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Random;

/**
 *
 * @author leducphi
 */
public class CartOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDAO dao = new CustomerDAO();
        String CompanyName = req.getParameter("txtCompanyName");
        String ContactName = req.getParameter("txtContactName");
        String ContactTitle = req.getParameter("txtContactTitle");
        String Address = req.getParameter("txtAddress");
//        Date date = (Date)req.getParameter("txtRequiredDate");
        Customers customer = (Customers) req.getSession().getAttribute("CusSession");
        Account acc = (Account) req.getSession().getAttribute("AccSession");

        try {
            Cart cart = null;
            Object o = req.getSession().getAttribute("cart");
            dao.updateProfile("GUEST", CompanyName, ContactName, ContactTitle, Address);
            Customers guest = dao.getCustomersByID("GUEST");
            if (o != null) {
                cart = (Cart) o;
            } else {
                cart = new Cart();
            }

            //in case user doesn't login yet 
            if (acc == null) {

                new OrderDAO().addOrder(guest, cart);
                req.getSession().removeAttribute("cart");
                req.getSession().setAttribute("size", 0);
                req.getSession().setAttribute("t", 0);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                new OrderDAO().addOrder(customer, cart);
                req.getSession().removeAttribute("cart");
                req.getSession().setAttribute("size", 0);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

        } catch (ServletException | IOException e) {
            System.out.println(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }
    
    
    public static void main(String[] args) {
        
    }
    
    

}
