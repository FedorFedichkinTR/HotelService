package com.epam.filters;

import lombok.extern.log4j.Log4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@Log4j
@WebFilter("/*")
public class LocaleFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String localeRequest = httpServletRequest.getParameter("locale");
//        String localeRequest = servletRequest.getParameter("locale");
        HttpSession session = httpServletRequest.getSession(true);
        if (localeRequest == null || localeRequest.isEmpty()) {
            Locale sessionLocale = (Locale) session.getAttribute("locale");
            if (sessionLocale == null) {
                session.setAttribute("locale", httpServletRequest.getLocale());
            }
        } else {
            session.setAttribute("locale", new Locale(localeRequest));
        }
        chain.doFilter(httpServletRequest, servletResponse);
    }
}
