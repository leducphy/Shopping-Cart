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
import java.util.List;

/**
 *
 * @author leducphi
 */
public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idx = req.getParameter("id");
        int id = Integer.parseInt(idx);
        boolean buy = false;
        try {
            buy = Boolean.parseBoolean(req.getParameter("buy"));
        } catch (Exception e) {
            buy = false;
        }
        Cart cart = null;
        Object o = req.getSession().getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        try {

            ProductDAO pD = new ProductDAO();
            Product p = pD.getProductByID(id);
            Item i = new Item(p, 1, p.getUnitPrice());
            cart.addItem(i);
            List<Item> list = cart.getItems();
            req.getSession().setAttribute("cart", cart);
            req.getSession().setAttribute("t", cart.getTotalMoney());
            req.getSession().setAttribute("size", list.size());
            if (!buy) {
                resp.sendRedirect("detail?model=" + id);
            } else {
                req.getRequestDispatcher("cart.jsp").forward(req, resp);
            }
        } catch (ServletException | IOException e) {
        }

    }

}
