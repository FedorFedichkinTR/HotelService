package com.epam.filters;

import com.epam.constants.Constants;
import com.epam.model.Role;
import com.epam.model.User;
import lombok.extern.log4j.Log4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j
@WebFilter("*.jsp")
public class SecurityFilter extends HttpFilter {
    private Pattern notAuthPattern = Pattern.compile(".*/static/.*");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(true);
        final User currentUser = ((User)session.getAttribute(Constants.USER_SESSION));
        final Role currentUserRole;
        if (currentUser != null) {
            currentUserRole = currentUser.getRole();
        } else {
            currentUserRole = null;
        }
        String path = Optional.ofNullable(httpServletRequest.getRequestURI()).orElse("");
        Matcher newMatcher = notAuthPattern.matcher(path);
        if (!newMatcher.find()) {
            if (currentUserRole == Role.USER
                    && httpServletRequest.getRequestURI().contains("/adminpage.jsp")) {
                request.getRequestDispatcher("myorders.jsp").forward(httpServletRequest, response);
            } else if (currentUserRole == Role.ADMINISTRATOR
                    && httpServletRequest.getRequestURI().contains("/myorders.jsp")) {
                request.getRequestDispatcher("adminpage.jsp").forward(httpServletRequest, response);
            } else if (currentUserRole == null) {
                if (httpServletRequest.getRequestURI().contains("/booking.jsp")
                        || httpServletRequest.getRequestURI().contains("/myorders.jsp")
                        || httpServletRequest.getRequestURI().contains("/adminpage.jsp")
                        || httpServletRequest.getRequestURI().contains("/test.jsp")) {
                    request.getRequestDispatcher("/index.jsp").forward(httpServletRequest, response);
                }
            }
        }
        chain.doFilter(httpServletRequest, response);
    }
}
