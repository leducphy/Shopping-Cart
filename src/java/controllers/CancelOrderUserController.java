/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Customers;
import DAL.Order;
import DAL.OrderDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.CustomerDAO;
import models.OrderDAO;

/**
 *
 * @author leducphi
 */
public class CancelOrderUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        try {
//            Account acc = (Account) req.getSession().getAttribute("AccSession");
//            Customers cus = new CustomerDAO().getCustomersByID(acc.getCustomerID());
            Customers cus = (Customers) req.getSession().getAttribute("CusSession");
            ArrayList<Order> listOrder = new OrderDAO().getListOrderByCusID(cus.getCustomerID());
            ArrayList<OrderDetails> listOrderDetail = new OrderDAO().getListOrderDetailByOID(listOrder);
            req.getSession().setAttribute("listOrder", listOrder);
            req.getSession().setAttribute("listOrderDetail", listOrderDetail);
            req.getRequestDispatcher("profile2.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            System.out.println(e);
        }
    }
}
