package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.model.Roles;
import com.epam.model.User;
import com.epam.services.AuthorisationService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userMail = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");
        // TODO: 11.10.2017 сервис используется многократно, каждый раз его достовать из контекста не надо.
        // Нужно вынести переменую в поле класса и проинициализировать один раз
        AuthorisationService authorise = (AuthorisationService) request.getServletContext().getAttribute(Constants.AUTHORISATION_SERVICE);
        User resultUser = authorise.getUser(userMail);
        // TODO: 11.10.2017 слишком много логики в контроллере, это нужно её как-то перенести в сервис
        //if there are no user with such name, if resultUser=null
        if (resultUser == null || resultUser.getUserID() == null) { // TODO: 11.10.2017 у нас разве может быть user в сессии без ID? Зачем проверять на null?
            request.setAttribute("error", "This user is not registered");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            //if password is wrong use exception. or check password there.
            if (!authorise.checkPassword(password, resultUser)) {
                request.setAttribute("error", "Invalid password");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute(Constants.USER_SESSION, resultUser);
                //if it's all right, go to page, based on role of the user.
                if (resultUser.getRole() == Roles.USER) {
                    request.getRequestDispatcher("/temp/booking.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/admin").forward(request, response);
                }
            }
        }
    }
}
