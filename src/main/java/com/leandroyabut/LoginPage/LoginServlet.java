package com.leandroyabut.LoginPage;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private String name;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        boolean loginSuccess = Boolean.parseBoolean(req.getParameter("success"));

        StringBuilder feedback = new StringBuilder("Login ");

        if(loginSuccess) {
            feedback.append("successful!");
        } else feedback.append("failed...");

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Login</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>" + feedback.toString() + "</h1>");
        writer.println("</body>");
        writer.println("</head>");
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