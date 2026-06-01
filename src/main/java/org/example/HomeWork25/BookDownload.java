package org.example.HomeWork25;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/book")
public class BookDownload extends HttpServlet {

    private static final String BOOKS_DIRECTORY = "/books";

    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
        throws IOException, ServletException {

        String fileName = httpServletRequest.getParameter("file");

        if (fileName == null || fileName.trim().isEmpty()) {
            showBookList(httpServletResponse);
        } else {
            downloadBook(fileName,httpServletResponse);
        }
    }

        private void showBookList(HttpServletResponse httpServletResponse) throws IOException {
            httpServletResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter out = httpServletResponse.getWriter();

            String bookPath = getServletContext().getRealPath(BOOKS_DIRECTORY);
            Path bookDirectory = Paths.get(bookPath);

            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Список книг</title></head><body>");
            out.println("<h1>Доступные книги</h1>");

            if (!Files.exists(bookDirectory)) {
                out.println("Alas, there is no books directory");
             return;}

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(bookDirectory)) {
                boolean hasFiles = false;
                out.println("<ul>");

                for (Path entry : stream) {
                    if (Files.isRegularFile(entry)) {
                        hasFiles = true;
                        String name = entry.getFileName().toString();
                        out.println("<li><a href='/time-servlet/book?file=" + name + "'>" + name + "</a></li>");
                    }
                }
                out.println("</ul>");

                if (!hasFiles) {
                    out.println("<p>В папке пока нет книг. Загрузите их через /load-book upload.html</p>");
                }
            }

            out.println("<hr>");
            out.println("<a href='/time-servlet/upload.html'>Загрузить новую книгу</a>");
            out.println("</body></html>");
        }

         private void downloadBook(String fileName, HttpServletResponse httpServletResponse) throws IOException {
            String bookPath = getServletContext().getRealPath(BOOKS_DIRECTORY);
            Path filePath = Paths.get(bookPath, fileName);

            if (!Files.exists(filePath) || Files.isDirectory(filePath)) {
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
                httpServletResponse.setContentType("text/html;charset=UTF-8");
                httpServletResponse.getWriter().println("<h1> Книга не найдена</h1>");
                httpServletResponse.getWriter().println("<a href='/time-servlet/book'>Вернуться к списку</a>");
                return;
            }

        //код ниже - скачивание самого файла
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName + "\"");

        Files.copy(filePath, httpServletResponse.getOutputStream());
    }
}
