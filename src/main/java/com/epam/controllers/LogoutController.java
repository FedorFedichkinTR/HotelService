package com.epam.controllers;

import com.epam.constants.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute(Constants.USER_SESSION);
        if (user != null) {
            request.getSession().removeAttribute("user");
        }
        response.sendRedirect("/index.jsp"); // TODO: 10.10.2017 можно отправлять просто на адрес "/"
    }
}
