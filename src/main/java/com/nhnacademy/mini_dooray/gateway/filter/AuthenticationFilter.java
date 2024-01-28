package com.nhnacademy.mini_dooray.gateway.filter;

import com.nhnacademy.mini_dooray.gateway.security.Member;
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
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();

        if (requestURI.equals(contextPath + "/member/login") ||
                requestURI.equals(contextPath + "/member/create")) {

            filterChain.doFilter(request, response);
            return;
        }

        Member member = (Member) request.getSession().getAttribute("member");

        if (member == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return;
        }

        filterChain.doFilter(request, response);
    }
}