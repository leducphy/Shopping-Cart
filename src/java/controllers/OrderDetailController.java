/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Account;
import DAL.Customers;
import DAL.Order;
import DAL.OrderDetailsDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.OrderDAO;

/**
 *
 * @author leducphi
 */
public class OrderDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        OrderDAO dao = new OrderDAO();
        try {
            Customers cus = (Customers) req.getSession().getAttribute("CusSession");
            ArrayList<OrderDetailsDTO> listOrder = dao.getListOrderByCusID(cus.getCustomerID());
            ArrayList<OrderDetailsDTO> listOrderDetail = dao.getListOrderDetailByOID(listOrder);
            

            req.getSession().setAttribute("listOrder", listOrder);
            req.getSession().setAttribute("listOrderDetail", listOrderDetail);
            req.getRequestDispatcher("profile1.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
        }

    }

}
