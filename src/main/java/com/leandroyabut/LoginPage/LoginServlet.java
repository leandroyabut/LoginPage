package com.leandroyabut.LoginPage;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private String name;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginstatus.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String wantedUsername = "username";
        String wantedPassword = "password";

        boolean loginSuccess = (username.equals(wantedUsername) && password.equals(wantedPassword));

        resp.sendRedirect("login?success=" + loginSuccess);
    }
}