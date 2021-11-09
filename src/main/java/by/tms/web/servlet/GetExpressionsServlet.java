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

@WebServlet("/history")
public class GetExpressionsServlet extends HttpServlet {
    private final InMemoryExpressionStorage inMemoryResultStorage = new InMemoryExpressionStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") != null) {
            User user = (User) req.getSession().getAttribute("user");
            List<Expression> expressions = inMemoryResultStorage.getExpressions(user.getLogin());
            req.setAttribute("expressions", expressions);
            getServletContext().getRequestDispatcher("/pages/historyExpressions.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("/");
        }
    }
}