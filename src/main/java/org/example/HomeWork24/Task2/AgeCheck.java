package org.example.HomeWork24.Task2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check-age")
public class AgeCheck extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        String ageParam = request.getParameter("age");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Проверяем возраст</title></head>");
        out.println("<body>");

        if (ageParam == null) {
            out.println("не указан возраст, надо бы после /check-age добавить: ?age=20");
        } else {
            try {
                int age = Integer.parseInt(ageParam);

                if (age >= 18) {
                    out.println("Вы - совершеннолетний");
                } else {
                    out.println("Вы - НЕсовершеннолетний");
                }
            } catch (NumberFormatException e) {
                out.println("Опять за старое? " + ageParam + " по твоему число?");
            }
        }

        out.println("</body>");
        out.println("</html>");

    }
}
