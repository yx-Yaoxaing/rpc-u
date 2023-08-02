package com.cqnews.rpc.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("=============================AuthFilter invoke....=====================================");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
