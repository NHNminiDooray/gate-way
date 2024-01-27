package com.nhnacademy.mini_dooray.gateway.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;

@WebFilter("/*")
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (request.getRequestURI().equals(request.getContextPath() + "/member/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        Object memberId = request.getSession().getAttribute("memberId");

        if (memberId == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return;
        }

        filterChain.doFilter(request, response);
    }
}