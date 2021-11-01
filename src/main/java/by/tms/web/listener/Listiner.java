package by.tms.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listiner {

    @WebListener
    public class Listener implements HttpSessionListener,
            HttpSessionAttributeListener, ServletContextListener {


        @Override
        public void contextInitialized(ServletContextEvent sce) {

        }

        @Override
        public void sessionCreated(HttpSessionEvent se) {

        }
    }
}
