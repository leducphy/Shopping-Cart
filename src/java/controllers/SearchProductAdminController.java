/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Category;
import DAL.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.CategoryDAO;
import models.ProductDAO;

/**
 *
 * @author leducphi
 */
public class SearchProductAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int CatID = Integer.parseInt(req.getParameter("ddlCategory"));
        ArrayList<Product> list = new ProductDAO().getProductsByCatID(CatID);
        req.setAttribute("products", list);
        ArrayList<Category> categories = new CategoryDAO().getCategory();
        req.setAttribute("categories", categories);
        req.setAttribute("CatID", CatID);

        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String CatIDs = req.getParameter("CatID");
        int CatID = Integer.parseInt(CatIDs);
        String name = req.getParameter("txtSearch");
        ArrayList<Product> products = null;
        if (CatID == 0) {
            products = new ProductDAO().searchProductName(name);
        } else {
            products = new ProductDAO().searchProductNameAndCatID(name, CatID);
        }
        req.setAttribute("products", products);
        req.setAttribute("nameSearch", name);
        ArrayList<Category> categories = new CategoryDAO().getCategory();
        req.setAttribute("categories", categories);
        req.setAttribute("CatID", CatID);
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }

}
