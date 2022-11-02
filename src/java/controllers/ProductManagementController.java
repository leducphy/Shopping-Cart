package controllers;

import DAL.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import models.*;

/**
 *
 * @author leducphi
 */
public class ProductManagementController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
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
            int elements = 10;
            ArrayList<Product> products = dao.getProductsByPage(page, elements);
            int numberOfPage = dao.getProducts().size() % elements == 0 ? dao.getProducts().size() / elements : dao.getProducts().size() / elements + 1;
            ArrayList<Category> categories = new CategoryDAO().getCategory();
            req.setAttribute("categories", categories);
            req.setAttribute("products", products);
            req.setAttribute("page", page);
            req.setAttribute("numberOfPage", numberOfPage);
            
            // cattegory = 0 mean search in all
            req.setAttribute("CatID", 0);

            req.getRequestDispatcher("product.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
        }
    }

}
