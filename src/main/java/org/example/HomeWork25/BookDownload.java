package org.example.HomeWork25;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/book")
public class BookDownload extends HttpServlet {

    private static final String BOOKS_DIRECTORY = "/books";

    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
        throws IOException, ServletException {

        Path bookPath = Paths.get(getServletContext().getRealPath("/book/GTA_SA_cheat_codes.txt"));
        System.out.println("Проверка, ищем файл по пути: " + bookPath.toAbsolutePath());


        if (!Files.exists(bookPath)) {
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            httpServletResponse.getWriter().println("Alas, there is no the book, lets try find another, ok?..");
            return;
        }
        //код ниже - скачивание самого файла
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + bookPath.getFileName().toString());

        //качаем пакетами, чтоб не забить память
        try (InputStream in = Files.newInputStream(bookPath);
             OutputStream out = httpServletResponse.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);

            }
        }
    }
}
