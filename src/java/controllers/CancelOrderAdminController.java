/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.OrderDAO;

/**
 *
 * @author leducphi
 */
public class CancelOrderAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int oid = Integer.parseInt(req.getParameter("oid"));
        req.setAttribute("oid", oid);
        OrderDAO dao = new OrderDAO();
        dao.cancelOrderByID(oid);
        Account acc = (Account) req.getSession().getAttribute("AccSession");
        if (acc.getRole() == 1) {
            resp.sendRedirect(req.getContextPath() + "/OrderManage");
        }
        else{
             resp.sendRedirect(req.getContextPath() + "/order-detail");
        }
    }

}
