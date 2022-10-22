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
public class UpdateProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("pid"));
        String txtProductName = req.getParameter("txtProductName");
        double UnitPrice = Double.parseDouble(req.getParameter("txtUnitPrice"));
        String QuantityPerUnit = req.getParameter("txtQuantityPerUnit");
        int UnitsInStock = Integer.parseInt(req.getParameter("txtUnitsInStock"));
        int CatID = Integer.parseInt(req.getParameter("ddlCategory"));
        int ReorderLevel = Integer.parseInt(req.getParameter("txtReorderLevel"));
        int UnitsOnOrder = Integer.parseInt(req.getParameter("txtUnitsOnOrder"));
        boolean Discontinued = Boolean.parseBoolean(req.getParameter("chkDiscontinued"));

        Product p = new Product(id, txtProductName, CatID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
        if (new ProductDAO().updateProduct(p) > 0) {
            resp.sendRedirect(req.getContextPath() + "/ManageProduct");
        } else {
            req.getRequestDispatcher("/update?pid=" + id).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pid = Integer.parseInt(req.getParameter("pid"));
        Product p = new ProductDAO().getProductByID(pid);
        ArrayList<Category> categoryList = new CategoryDAO().getCategory();
        req.setAttribute("pid", pid);
        req.setAttribute("txtProductName", p.getProductName());
        req.setAttribute("txtUnitPrice", p.getUnitPrice());
        req.setAttribute("txtQuantityPerUnit", p.getQuantityPerUnit());
        req.setAttribute("txtUnitsInStock", p.getUnitsInStock());
        req.setAttribute("ddlCategory", p.getCategoryID());
        req.setAttribute("txtReorderLevel", p.getReorderLevel());
        req.setAttribute("txtUnitsOnOrder", p.getUnitsOnOrder());
        req.setAttribute("chkDiscontinued", p.isDiscontinued());
        req.setAttribute("categories", categoryList);
        req.getRequestDispatcher("edit-product.jsp").forward(req, resp);
    }

}
