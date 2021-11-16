package by.tms.web.servlet.user;

import by.tms.entity.User;
import by.tms.service.Calc;
import by.tms.storage.InMemoryResultStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
    private final InMemoryResultStorage inMemoryResultStorage = new InMemoryResultStorage();
    private List<Double> listOfNumbers = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            getServletContext().getRequestDispatcher("/pages/user/calculator.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) (req.getSession().getAttribute("user"));
        String[] nums = req.getParameterValues("num");
        for (String s : nums) {
            if (s.matches("(-|\\+)?\\d+") && !s.isEmpty()) {
                listOfNumbers.add(Double.parseDouble(s));
            } else {
                req.setAttribute("error", "Wrong number");
            }
        }
        String operation = req.getParameter("operation");
        double result = Calc.valueOf(operation).compute(listOfNumbers.get(0), listOfNumbers.get(1));
        inMemoryResultStorage.saveResult(user.getLogin(), listOfNumbers.get(0), operation, listOfNumbers.get(1), result);
        req.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/pages/user/calculator.jsp").forward(req, resp);
    }
}


//    User user = (User) req.getSession().getAttribute("user");
//    List<Double> nums = (List<Double>) req.getAttribute("listOfNumbers");
//    String operation = req.getParameter("operation");
//    double result = Calc.valueOf(operation).compute(nums.get(0), nums.get(1));
//            inMemoryResultStorage.saveResult(user.getLogin(), nums.get(0), operation, nums.get(1), result);
//            req.setAttribute("result", result);
//    getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
