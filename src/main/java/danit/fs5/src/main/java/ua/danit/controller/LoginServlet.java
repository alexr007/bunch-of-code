package danit.fs5.src.main.java.ua.danit.controller;

import ua.danit.dao.UserDAO;
import ua.danit.model.User;
import ua.danit.utils.FreeMarker;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    private final FreeMarker template;

    public LoginServlet(FreeMarker template) {
        this.template=template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        template.render("login.html", new HashMap<>(), resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("userLogin");
        String passward = req.getParameter("passward");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.get(login);

        if (user != null && user.getPassword().equals(passward)) {
            Cookie cookie = new Cookie("userLogin", req.getParameter("userLogin"));
            cookie.setMaxAge(60);

            resp.addCookie(cookie);
            resp.sendRedirect("users");

        } else {
            resp.sendRedirect("/login");
        }

    }
}
