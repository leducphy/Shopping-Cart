package controllers;

import DAL.Order;
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
public class AllOrderAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String txtStartOrderDate = req.getParameter("txtStartOrderDate");
            String txtEndOrderDate = req.getParameter("txtEndOrderDate");
            req.setAttribute("txtStartOrderDate", txtStartOrderDate);
            req.setAttribute("txtEndOrderDate", txtEndOrderDate);
            ArrayList<Order> list = new OrderDAO().getListByFilterDate(txtStartOrderDate, txtEndOrderDate);
            req.getSession().setAttribute("listAll", list);
            req.getRequestDispatcher("order.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ArrayList<Order> list = new OrderDAO().getListByFilterDate("1996-09-11", "2022-10-25");
        try {
            String txtStartOrderDate = req.getParameter("txtStartOrderDate");
            String txtEndOrderDate = req.getParameter("txtEndOrderDate");
            ArrayList<Order> list = new OrderDAO().getListOrders();
            req.setAttribute("txtStartOrderDate", txtStartOrderDate);
            req.setAttribute("txtEndOrderDate", txtEndOrderDate);
            req.setAttribute("listAll", list);
            req.getRequestDispatcher("order.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            System.out.println(e);
        }
    }

}
