package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.model.Role;
import com.epam.model.User;
import com.epam.services.AuthorisationService;
import com.epam.exceptions.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private AuthorisationService authorise;

    @Override
    public void init() throws ServletException {
        authorise = (AuthorisationService) getServletContext().getAttribute(Constants.AUTHORISATION_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userMail = request.getParameter("input-email");
        String password = request.getParameter("input-password");
        try{
            User resultUser = authorise.authorize(userMail,password);
            request.getSession().setAttribute(Constants.USER_SESSION, resultUser);
            if (resultUser.getRole() == Role.USER) {
                request.getRequestDispatcher("/WEB-INF/booking.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/admin").forward(request, response);
            }
        } catch(UnmatchedPassword | UserDoesNotExist e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
