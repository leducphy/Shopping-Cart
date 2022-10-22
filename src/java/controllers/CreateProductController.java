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
public class CreateProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String txtProductName = req.getParameter("txtProductName");
        double UnitPrice = Double.parseDouble(req.getParameter("txtUnitPrice"));
        String QuantityPerUnit = req.getParameter("txtQuantityPerUnit");
        int UnitsInStock = Integer.parseInt(req.getParameter("txtUnitsInStock"));
        int CatID = Integer.parseInt(req.getParameter("ddlCategory"));
        int ReorderLevel = Integer.parseInt(req.getParameter("txtReorderLevel"));
        int UnitsOnOrder = Integer.parseInt(req.getParameter("txtUnitsOnOrder"));
        boolean Discontinued = Boolean.parseBoolean(req.getParameter("chkDiscontinued"));

        Product p = new Product(0, txtProductName, CatID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
        if (new ProductDAO().addProduct(p) > 0) {
            resp.sendRedirect(req.getContextPath() + "/ManageProduct");
        } else {
            req.getRequestDispatcher("/AddProduct").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> categories = new CategoryDAO().getCategory();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("create-product.jsp").forward(req, resp);
    }

}
