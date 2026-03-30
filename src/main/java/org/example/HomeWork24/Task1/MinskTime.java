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

@WebServlet("/minsk")
public class MinskTime extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        ZoneId zoneId = ZoneId.of("Europe/Minsk");
        LocalDateTime nowTime = LocalDateTime.now(zoneId);
        String timeFormat = nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Время в Минске</title></head>");
        out.println("<body>");
        out.println("Минск");
        out.println("<p>Текущее время: " + timeFormat + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
