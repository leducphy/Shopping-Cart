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
//        Cart cart = null;
//        Object obj = req.getSession().getAttribute("cart");
//        if (obj != null) {
//            cart = (Cart) obj;
//        } else {
//            cart = new Cart();
//        }
//
//        String tid = req.getParameter("id");
//        int id = Integer.parseInt(tid);
//
//        try {
//            Product p = new ProductDAO().getProductByID(id);
//            double price = p.getUnitPrice() * 0.1;
//
//            Item t = new Item(p, 1, price);
//
//            cart.addItem(t);
//
//            List<Item> list = cart.getItems();
//            req.setAttribute("cart", cart);
//
//            req.getRequestDispatcher("cart.jsp").forward(req, resp);
//        } catch (NumberFormatException e) {
//        }
        
        String idx = req.getParameter("id");
        int id = Integer.parseInt(idx);

        Cart cart = null;
        Object o = req.getSession().getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        try {

            ProductDAO pD = new ProductDAO();
            //ArrayList<Product> listP = pD.getProductsByID(id);
            Product p = pD.getProductByID(id);
            Item i = new Item(p, 1, p.getUnitPrice());
            cart.addItem(i);

            //req.getSession().setAttribute("list", listP);
            List<Item> list = cart.getItems();
            req.getSession().setAttribute("cart", cart);
            double t;
            int as = 0;
            for (Item ai : list) {
                as = ai.getProduct().getProductID();
            }
            
            t = cart.getTotalMoney();
            req.getSession().setAttribute("t", t);
            req.getSession().setAttribute("as", as);
            
            //req.getRequestDispatcher("cart.jsp").forward(req, resp);
            req.getSession().setAttribute("size", list.size());
            req.getRequestDispatcher("cart.jsp").forward(req, resp);

        } catch (Exception e) {
        }

    }

}
