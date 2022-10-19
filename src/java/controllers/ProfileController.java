/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Customers;
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
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int accountID = Integer.parseInt(req.getParameter("accountID"));
        req.getSession().setAttribute("accID", accountID);
        Customers cus = new CustomerDAO().getProfile(accountID);
        req.getSession().setAttribute("CusSession", cus);
        req.getRequestDispatcher("../profile.jsp").forward(req, resp);
    }
}
