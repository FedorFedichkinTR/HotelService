package com.epam.filters;

import com.epam.model.Roles;
import lombok.extern.log4j.Log4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@Log4j
@WebFilter("*.jsp")
public class SecurityFilter extends HttpFilter {
    //    private Pattern notAuthPattern = Pattern.compile("^((\\/static\\/.*)|(\\/j_security_check$)|(^\\/not_auth\\/.*))");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(true);
        final Roles currentUserRole = (Roles) session.getAttribute("currentSessionRole");
        if (currentUserRole == Roles.USER
                && httpServletRequest.getRequestURI().contains("/adminpage.jsp")) {
            request.getRequestDispatcher("myorders.jsp").forward(httpServletRequest, response);
        } else if (currentUserRole == Roles.ADMINISTRATOR
                && httpServletRequest.getRequestURI().contains("/myorders.jsp")) {
            request.getRequestDispatcher("adminpage.jsp").forward(httpServletRequest, response);
        } else if (currentUserRole == null) {
            if (httpServletRequest.getRequestURI().contains("/temp/booking.jsp")
                    || httpServletRequest.getRequestURI().contains("/temp/myorders.jsp")
                    || httpServletRequest.getRequestURI().contains("/temp/adminpage.jsp")
                    || httpServletRequest.getRequestURI().contains("/temp/test.jsp")) {
                request.getRequestDispatcher("/index.jsp").forward(httpServletRequest, response);
            }
        }
        chain.doFilter(httpServletRequest, response);
    }
}
