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
 * @author Admin
 */
public class CategoryListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        ArrayList<Category> categoryList = new CategoryDAO().getCategory();
        ArrayList<Product> productBestSaleList = new ProductDAO().getBestSaleProducts();
        ArrayList<Product> NEWproductList = new ProductDAO().getNEWProducts();
        ArrayList<Product> productHotList = new ProductDAO().getHotProducts();
        int page = 0;
        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (NumberFormatException e) {
            page = 1;
        }
        // check sau khi insert neu khong phai page 1 thi se khong in ra cai product vua add vao 
        if (page != 1) {
            Product newProduct = null;
            req.getSession().setAttribute("newProduct", newProduct);
        }
        ProductDAO dao = new ProductDAO();
        int elements = 4;
        ArrayList<Product> products = dao.getProductsByPage(page, elements);
        int numberOfPage = dao.getProducts().size() % elements == 0 ? dao.getProducts().size() / elements : dao.getProducts().size() / elements + 1;
        ArrayList<Category> categories = new CategoryDAO().getCategory();
        req.setAttribute("categories", categories);
        req.setAttribute("products", products);
        req.setAttribute("page", page);
        req.setAttribute("numberOfPage", numberOfPage);
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("NEWproductList", NEWproductList);
        req.setAttribute("productBestSaleList", productBestSaleList);
        req.setAttribute("productHotList", productHotList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
       
    }
    
}
