package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.service.Calc;
import by.tms.storage.InMemoryExpressionStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
    private final InMemoryExpressionStorage inMemoryResultStorage = new InMemoryExpressionStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Double> nums = (List<Double>) req.getAttribute("listOfNumbers");
        String operation = req.getParameter("operation");
        double result = Calc.valueOf(operation).compute(nums.get(0), nums.get(1));
        inMemoryResultStorage.saveExpression(user.getId(), nums.get(0), operation, nums.get(1), result);
        req.setAttribute("result", result);
    }
}