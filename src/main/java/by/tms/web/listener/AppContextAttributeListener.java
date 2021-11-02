package by.tms.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Атрибут добавлен :{" + event.getName() +
                ", " + event.getValue() + "}");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("Атрибут удален:{"+event.getName()+","+event.getValue()+"}");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("Атрибут изменен:{"+event.getName()+","+event.getValue()+"}");
    }
}
