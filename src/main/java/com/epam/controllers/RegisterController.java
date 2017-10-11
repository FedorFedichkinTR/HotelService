package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private RegistrationService registrationService;

    @Override
    public void init() throws ServletException {
        registrationService = (RegistrationService) getServletContext().getAttribute(Constants.REGISTRATION_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userMail = request.getParameter("input-email");
        String userPassword = request.getParameter("input-password");
        String userFirstName = request.getParameter("input-first-name");
        String userLastName = request.getParameter("input-last-name");
        if (registrationService.signUp(userMail, userPassword, userFirstName, userLastName)) {
            request.getRequestDispatcher("/login").forward(request, response);
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "This user is already registered");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
