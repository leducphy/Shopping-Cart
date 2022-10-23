
package controllers;

import DAL.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.*;

/**
 *
 * @author leducphi
 */
public class DetailProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        ProductDAO dao = new ProductDAO();
        int pid = Integer.parseInt(req.getParameter("model"));
        Product product = dao.getProductByID(pid);
        Category cat = new CategoryDAO().getCategoryByID(product.getCategoryID());

        req.setAttribute("pid", product.getProductID());
        req.setAttribute("pname", product.getProductName());
        req.setAttribute("pprice", product.getUnitPrice());
        req.setAttribute("pstatus", product.getUnitsInStock());
        req.setAttribute("categoryID", product.getCategoryID());
        req.setAttribute("catName", cat.getCategoryName());

        req.getRequestDispatcher("detail.jsp").forward(req, resp);
    }


}
