package by.tms.web.servlet;

import by.tms.storage.InMemoryResultStorage;
import by.tms.storage.InMemoryUserStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("id") != null) {
            int id = (Integer) req.getSession().getAttribute("id");
            inMemoryUserStorage.delete(id);
            inMemoryUserStorage.delete(id);
            resp.sendRedirect("/logout");
        } else {
            resp.sendRedirect("/");
        }
    }
}