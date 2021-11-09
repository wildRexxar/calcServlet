package by.tms.web.servlet;

import by.tms.entity.Expression;
import by.tms.entity.User;
import by.tms.storage.InMemoryExpressionStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user_history")
public class GetUserHistoryServlet extends HttpServlet {

    private final InMemoryExpressionStorage inMemoryExpressionStorage = new InMemoryExpressionStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/userHistory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user != null && user.getStatus()) {
            String login = req.getParameter("login");
            List<Expression> expressions = inMemoryExpressionStorage.getExpressions(login);
            req.setAttribute("expressions", expressions);
            resp.sendRedirect("/history");
        } else {
            resp.sendRedirect("/");
        }
    }
}
