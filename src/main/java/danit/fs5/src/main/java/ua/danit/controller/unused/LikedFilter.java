package danit.fs5.src.main.java.ua.danit.controller.unused;

import ua.danit.dao.UserDAO;
import ua.danit.utils.GetLoginByCookie;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LikedFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        GetLoginByCookie getLoginByCookie = new GetLoginByCookie();
        Cookie[] cookies = req.getCookies();
        UserDAO userDAO = new UserDAO();

        if (cookies != null) {
            if (userDAO.get(getLoginByCookie.getLogin(cookies)) == null) {
                resp.sendRedirect("/login");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
