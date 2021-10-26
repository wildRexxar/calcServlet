package by.tms.web.servlet;

import by.tms.storage.InMemoryResultStorage;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(inMemoryUserStorage.setDefaultUserIndex() == -1){
            resp.getWriter().println("you are logged out of your account");
        } else {
            resp.getWriter().println("you are not logged out of your account");
        }
    }
}