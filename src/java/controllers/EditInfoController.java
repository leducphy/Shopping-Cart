/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.CustomerDAO;

/**
 *
 * @author leducphi
 */
public class EditInfoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ID = (String) req.getSession().getAttribute("id");
        String CompanyName = req.getParameter("Companyname");
        String ContactName = req.getParameter("ContactName");
        String ContactTitle = req.getParameter("ContactTitle");
        String Address = req.getParameter("Address");
        String AccountID = req.getParameter("AccountID");
        try {
            CustomerDAO x = new CustomerDAO();
            x.updateProfile(ID, CompanyName, ContactName, ContactTitle, Address);
            resp.sendRedirect("profile?accountID=" + AccountID);
        } catch (IOException e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ID = req.getParameter("CusID");
        try {
            req.getSession().setAttribute("id", ID);
            req.getRequestDispatcher("../editInfo.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
        }
    }

}
