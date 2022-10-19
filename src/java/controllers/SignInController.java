/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.AccountDAO;

/**
 *
 * @author leducphi
 */
public class SignInController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDAO dao = new AccountDAO();
        resp.setContentType("text/html;charset=utf-8");
        String email = req.getParameter("txtEmail");
        String pass = req.getParameter("txtPass");
        String msgEmail = "";
        String msgPass = "";

        if (email.equals("")) {
            msgEmail = "Email is requied";
            req.setAttribute("msgEmail", msgEmail);
        }

        if (email.equals("")) {
            msgPass = "Password is requied";
            req.setAttribute("msgPass", msgPass);
        }

        if (!msgEmail.equals("") || !msgPass.equals("")) {
            req.getRequestDispatcher("../signin.jsp").forward(req, resp);
        } else {

            Account acc = dao.getAccount(email, pass);
            if (acc != null) {
                //cap session
                
                req.getSession().setAttribute("AccSession", acc);
                //dieu huong toi index
                if (acc.getRole()==2) {
                    resp.sendRedirect(req.getContextPath() + "/category-list");
                } else if(acc.getRole() == 1){
                    resp.sendRedirect(req.getContextPath() + "/dashboard.jsp");
                }
                
            } else {
                // else thi gui thong diep error ve doGet(login.jsps)
                req.setAttribute("txtEmail", email);
                req.setAttribute("msg", "Account not exist");
                req.getRequestDispatcher("../signin.jsp").forward(req, resp);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if (req.getSession().getAttribute("AccSession") != null) {
            req.getSession().removeAttribute("AccSession");
            resp.sendRedirect(req.getContextPath() + "/category-list");
        } else {
            req.getRequestDispatcher("../signin.jsp").forward(req, resp);
        }
    }

}
