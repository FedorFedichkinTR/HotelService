package com.epam.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebFilter("/*")
public class LocaleFilter extends HttpFilter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String localeRequest = httpServletRequest.getParameter("locale");
        HttpSession session = httpServletRequest.getSession(true);
        if (localeRequest == null || localeRequest.isEmpty()) {
            Locale localeSession = (Locale) session.getAttribute("locale");
            if (localeSession == null) {
                session.setAttribute("locale", httpServletRequest.getLocale());
            }
        } else {
            session.setAttribute("locale", new Locale(localeRequest));
        }
        chain.doFilter(httpServletRequest, servletResponse);
    }
}
