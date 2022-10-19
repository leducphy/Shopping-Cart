/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Account;
import DAL.Customers;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.AccountDAO;

/**
 *
 * @author leducphi
 */
public class SignupController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        ArrayList<Account> AccList = new AccountDAO().getAccounts();
        String CustomerID = randomString(5);
        String CompanyName = req.getParameter("txtCopName");
        String ContactName = req.getParameter("txtCName");
        String Tittle = req.getParameter("txtTitle");
        String Address = req.getParameter("txtAddress");
        String Email = req.getParameter("txtEmail");
        String Pass = req.getParameter("txtPass");
        String RePass = req.getParameter("txtRePass");
        String msgCPN = "";
        String msgCTN = "";
        String msgCTT = "";
        String msgADR = "";
        String msgE = "";
        String msgP = "";
        String msgRP = "";

        //luu ki tu da nhap-------------
        
        req.setAttribute("txtCopName", CompanyName);
        req.setAttribute("txtCName", ContactName);
        req.setAttribute("txtTitle", Tittle);
        req.setAttribute("txtAddress", Address);
        req.setAttribute("txtEmail", Email);

        //----------------------
        Customers cus = new Customers(CustomerID, CompanyName, ContactName, Tittle, Address, "", Email);
        Account acc = new Account(0, Email, Pass, CustomerID, 0, 0);

        if (CompanyName.equals("")) {
            msgCPN = "Companyname is required";
            req.setAttribute("msgCPN", msgCPN);
        }
        if (ContactName.equals("")) {
            msgCTN = "Contactname is required";
            req.setAttribute("msgCTN", msgCTN);
        }
        if (Tittle.equals("")) {
            msgCTT = "Contacttitle is required";
            req.setAttribute("msgCTT", msgCTT);
        }
        if (Address.equals("")) {
            msgADR = "Address is required";
            req.setAttribute("msgADR", msgADR);
        }

        if (Email.equals("")) {
            msgE = "Email is required";
            req.setAttribute("msgE", msgE);
        }
        //check email account in db
        for (Account a : AccList) {
            if (a.getEmail().equals(Email)) {
                msgE = "Email was used, Please usse another Email";
                req.setAttribute("msgE", msgE);
            }
        }
        //
        
        String regex = "^[a-zA-Z]\\w+@\\w+(\\.\\w+){1,3}$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Email);
            if (matcher.matches() == false) {
                msgE = "Email is wrong format";
                req.setAttribute("msgE", msgE);
            }
        if (Pass.equals("")) {
            msgP = "Password is required";
            req.setAttribute("msgP", msgP);
        }
        if (RePass.equals("")) {
            msgRP = "RePassword is required";
            req.setAttribute("msgRP", msgRP);
        }

        if (!msgE.equals("")
                || !msgP.equals("")
                || !msgRP.equals("")
                || !msgADR.equals("")
                || !msgCTT.equals("")
                || !msgCTN.equals("")
                || !msgCPN.equals("")) {
            req.getRequestDispatcher("../signup.jsp").forward(req, resp);
        } else {
            if (new AccountDAO().AddAccount(acc, cus) > 0) {
                resp.sendRedirect(req.getContextPath() + "/account/signin");
            } else {

                req.getRequestDispatcher("../signup.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if (req.getSession().getAttribute("AccSession") == null) {
            req.getRequestDispatcher("../signup.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher(req.getContextPath() + "/index.jsp").forward(req, resp);
        }
    }

    private String randomString(int length) {
        Random random = new Random();
        String setOfCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ab = "";
        String abc = "";
        for (int i = 0; i < length; i++) {
            ab = Character.toString(setOfCharacters.charAt(random.nextInt(setOfCharacters.length())));
            abc += ab;
        }
        return abc;
    }

    private ArrayList<String> getString(String txt) {
        StringTokenizer token = new StringTokenizer(txt);
        ArrayList<String> txtFinal = new ArrayList<>();
        String word = token.nextToken();
        while (token.hasMoreTokens()) {
            txtFinal.add(word + " ");
        }
        return txtFinal;
    }

}
