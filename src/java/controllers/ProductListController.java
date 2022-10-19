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
public class ProductListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int categoryID = Integer.parseInt(req.getParameter("category-id"));
        String categoryName = "";
        ArrayList<Product> productList = new ProductDAO().getProducts();
        ArrayList<Category> categoryList = new CategoryDAO().getCategory();
        ArrayList<Product> output = new ArrayList<>();
        
        String categoryDescription = "";
        for (Product item : productList) {
            if (item.getCategoryID() == categoryID) {
                output.add(item);
            }
        }
        for (Category item : categoryList) {
            if (item.getCategoryID() == categoryID) {
                categoryName = item.getCategoryName();
                categoryDescription = item.getDescription();
            }
        }

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
        int elements = 20;
        ArrayList<Product> products = dao.getProductsByPage(page, elements);
        int numberOfPage = dao.getProducts().size() % elements == 0 ? dao.getProducts().size() / elements : dao.getProducts().size() / elements + 1;
        ArrayList<Category> categories = new CategoryDAO().getCategory();
        req.setAttribute("categories", categories);
        req.setAttribute("products", products);
        req.setAttribute("page", page);
        req.setAttribute("numberOfPage", numberOfPage);
        req.setAttribute("categoryList", categoryList);

        req.setAttribute("cateDesc", categoryDescription);
        req.setAttribute("input-category-name", categoryName);
        req.setAttribute("cateListByID", output);
        
        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }

}
