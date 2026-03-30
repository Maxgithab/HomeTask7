package org.example.HomeWork24.Task1;
/*Задача 1:
Создать приложение, которое при переходе на следующие урлы будет выдавать
результат:
/minsk - время в Минске
/washington - время в Вашингтоне
/beijing - время в Пекине
При решении использовать оба варианта настройки (xml и аннотации).*/


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class WashingtonTime extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        ZoneId zoneId = ZoneId.of("America/New_York");
        LocalDateTime nowTime = LocalDateTime.now(zoneId);
        String timeFormat = nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Время в Вашингтоне</title></head>");
        out.println("<body>");
        out.println("Вашингтон");
        out.println("<p>Текущее время: " + timeFormat + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
