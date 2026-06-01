package org.example.HomeWork25;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/load-book")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 10,
    maxRequestSize = 1024 * 1024 * 15
)

public class BookUpload extends HttpServlet {

    private static final String UPLOADED = "books";

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
        throws ServletException, IOException {

        Part filePart = httpServletRequest.getPart("file");

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String uploadPath = getServletContext().getRealPath("") + UPLOADED;

        java.nio.file.Path uploadDirectory = java.nio.file.Paths.get(uploadPath);
        if (!java.nio.file.Files.exists(uploadDirectory)) {
            java.nio.file.Files.createDirectories(uploadDirectory);
        }

        String filePath = uploadPath + java.io.File.separator + fileName;

        filePart.write(filePath);

        httpServletResponse.setContentType("text/html;charset=UTF-8");
        httpServletResponse.getWriter().println("<body>");
        httpServletResponse.getWriter().println("<h1>Файл загружен<h1>");
        httpServletResponse.getWriter().println("<p><strong>Имя файла:</strong> " + fileName);
        httpServletResponse.getWriter().println("<p><strong>Путь:</strong> " + filePath);
        httpServletResponse.getWriter().println("<p><a href='/time-servlet/book?file=" + fileName + "'>Попробуй скачать загруженный файл обратно</a></p>");
        httpServletResponse.getWriter().println("<p>или</p>");
        httpServletResponse.getWriter().println("<p><a href='/time-servlet/book'> Перейти на страницу доступных книг для скачивания</a></p>");
        httpServletResponse.getWriter().println("</body>");
    }
}
