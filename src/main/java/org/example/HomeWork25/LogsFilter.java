package org.example.HomeWork25;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebFilter("/*")
public class LogsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        String url = httpServletRequest.getRequestURI();

        System.out.println("- Время ДО обработки сервлетом: " + time + " Запрос по " + url);

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("- Время ПОСЛЕ обработки сервлетом: " + time + " Ответ на " + url);


    }
}
