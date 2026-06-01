package org.example.HomeWork25;
/*Написать приложение, которое при запуске будет сообщать в консоль что оно
работает. На любой запрос в консоли должна отображаться запись со временем этого
запроса.
Создать 2 эндпоинта:
/book - который будет скачивать с сервера клиенту любую книгу.
/load-book - который позволит загружать свои книги на сервер*/

//ПОМЕТКА!!! текст виден при запуске через сmd, и далее в окне Tomcat

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("==============================");
        System.out.println("Это приложение сейчас работает");
        System.out.println("==============================");//текст виден через запуске сmd, и далее в окне Tomcat
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Приложение остановлено");
    }
}
