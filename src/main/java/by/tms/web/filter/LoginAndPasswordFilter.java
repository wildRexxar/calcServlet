package by.tms.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/registration")
public class LoginAndPasswordFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, res);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (!login.matches("\\s*|") && !password.matches("\\s*")){
            req.setAttribute("login", login);
            req.setAttribute("password", password);
        }
        else {
            req.setAttribute("login", null);
            req.setAttribute("password", null);
        }
        chain.doFilter(req, res);
    }
}
