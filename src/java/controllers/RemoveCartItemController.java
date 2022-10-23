/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Cart;
import DAL.Item;
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
public class RemoveCartItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart sc = null;
        Object o = req.getSession().getAttribute("cart");
        if (o != null) {
            sc = (Cart) o;
        } else {
            sc = new Cart();
        }

        String tid = req.getParameter("id");

        int id;
        try {
            id = Integer.parseInt(tid);
            sc.removeItem(id);

            List<Item> list = sc.getItems();
            req.getSession().setAttribute("cast", sc);
            req.getSession().setAttribute("size", list.size());
            req.getSession().setAttribute("t", sc.getTotalMoney());

            req.getRequestDispatcher("cart.jsp").forward(req, resp);

        } catch (ServletException | IOException | NumberFormatException e) {
        }
    }

}
