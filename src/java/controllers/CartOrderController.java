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
import java.io.PrintWriter;

/**
 *
 * @author leducphi
 */
public class CartOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDAO dao = new CustomerDAO();
        PrintWriter out = resp.getWriter();
        String CompanyName = req.getParameter("txtCompanyName");
        String ContactName = req.getParameter("txtContactName");
        String ContactTitle = req.getParameter("txtContactTitle");
        String Address = req.getParameter("txtAddress");
        String RequiredDate = req.getParameter("txtRequiredDate");

        Customers customer = (Customers) req.getSession().getAttribute("CusSession");
        Account acc = (Account) req.getSession().getAttribute("AccSession");

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
            //in case nothing on cart
            if (req.getSession().getAttribute("cart") == null) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Ban can it nhat 1 san phan trong gio hang de co the dat hang');");
                out.println("location='index.jsp';");
                out.println("</script>");
            } else {
                new OrderDAO().addOrder(guest, cart, RequiredDate);
                req.getSession().removeAttribute("cart");
                req.getSession().setAttribute("size", 0);
                req.getSession().setAttribute("t", 0);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Ban da dat hang thanh cong');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }

        } else {
            
            if (req.getSession().getAttribute("cart") == null) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Ban can it nhat 1 san phan trong gio hang de co the dat hang');");
                out.println("location='index.jsp';");
                out.println("</script>");
            } else {
                new OrderDAO().addOrder(customer, cart, RequiredDate);
                req.getSession().removeAttribute("cart");
                req.getSession().setAttribute("size", 0);
                req.getSession().setAttribute("t", 0);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Ban da dat hang thanh cong');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

}
