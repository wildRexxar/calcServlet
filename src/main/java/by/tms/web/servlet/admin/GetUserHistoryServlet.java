package by.tms.web.servlet.admin;

import by.tms.entity.Result;
import by.tms.entity.User;
import by.tms.storage.InMemoryResultStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userHistory")
public class GetUserHistoryServlet extends HttpServlet {

    private final InMemoryResultStorage inMemoryExpressionStorage = new InMemoryResultStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user != null && user.getStatus()) {
            getServletContext().getRequestDispatcher("/pages/admin/usersResultsHistory.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String login = req.getParameter("login");
            List<Result> listOfResults = inMemoryExpressionStorage.getListOfResults(login);
            req.setAttribute("listOfResults", listOfResults);
            getServletContext().getRequestDispatcher("/pages/resultHistory.jsp").forward(req, resp);
    }
}
