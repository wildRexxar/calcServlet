package by.tms.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebFilter (urlPatterns = "/calc")
public class OperationCalcFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String operation = req.getParameter("operation");
        if (operation.matches("(plus|minus|multiple|divided)")) {
            req.getSession().setAttribute("operation", operation.toUpperCase(Locale.ROOT));
        } else {
            req.getSession().setAttribute("operation", null);
        }
        chain.doFilter(req, res);
    }
}