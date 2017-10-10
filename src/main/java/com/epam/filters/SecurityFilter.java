package com.epam.filters;

import lombok.extern.log4j.Log4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j
@WebFilter("*.jsp")
public class SecurityFilter extends HttpFilter {
    private final static String CURRENT_USER = "currentUser";
//    private Pattern notAuthPattern = Pattern.compile("^((\\/static\\/.*)|(\\/j_security_check$)|(^\\/not_auth\\/.*))");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(true);
        if (session.getAttribute(CURRENT_USER) != null) {
            request.getRequestDispatcher("/webapp/temp/booking.jsp").forward(httpServletRequest, response);
        } else {
            if (!httpServletRequest.getRequestURI().contains("register")
                    || httpServletRequest.getRequestURI().contains("/temp/booking.jsp")
                    || httpServletRequest.getRequestURI().contains("/temp/myorders.jsp")
                    || httpServletRequest.getRequestURI().contains("/temp/adminpage.jsp")
                    || httpServletRequest.getRequestURI().contains("/temp/test.jsp")) {
                request.getRequestDispatcher("/index.jsp").forward(httpServletRequest, response);
            }
        }
        chain.doFilter(httpServletRequest, response);
    }
}
