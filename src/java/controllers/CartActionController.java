/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Cart;
import DAL.Item;
import DAL.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import models.ProductDAO;

/**
 *
 * @author leducphi
 */
public class CartActionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart sc = null;
        Object o = req.getSession().getAttribute("cart");
        if (o != null) {
            sc = (Cart) o;
        } else {
            sc = new Cart();
        }
        String tnum = req.getParameter("num");
        String tid = req.getParameter("id");

        int id, num;
        try {
            id = Integer.parseInt(tid);
            num = Integer.parseInt(tnum);

            if ((num == -1) && (sc.getQuantityByID(id) <= 1)) {
                sc.removeItem(id);
            } else {
                Product p = new ProductDAO().getProductByID(id);
                Item t = new Item(p, num, p.getUnitPrice());
                sc.addItem(t);
            }
        } catch (NumberFormatException e) {
        }

        List<Item> list = sc.getItems();

        req.getSession().setAttribute("t", sc.getTotalMoney());
        req.getSession().setAttribute("cast", sc);
        req.getSession().setAttribute("size", list.size());
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

}
