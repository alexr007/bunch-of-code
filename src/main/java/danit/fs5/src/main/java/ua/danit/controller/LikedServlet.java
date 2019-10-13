package danit.fs5.src.main.java.ua.danit.controller;

import ua.danit.dao.LikedDAO;
import ua.danit.dao.UserDAO;
import ua.danit.model.User;
import ua.danit.utils.FreeMarker;
import ua.danit.utils.GetLoginByCookie;
import ua.danit.utils.HtmlFreeMarker;
import ua.danit.utils.UserList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LikedServlet extends HttpServlet {
    private final FreeMarker template;

    public LikedServlet(FreeMarker template) {
        this.template=template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        GetLoginByCookie getLoginByCookie = new GetLoginByCookie();
        LikedDAO likedDAO = new LikedDAO();
        UserDAO userDAO = new UserDAO();
        List<String> personList = likedDAO.getListOfLikedUsers(getLoginByCookie.getLogin(cookies));
        UserList htmlUtil = new UserList(personList);
        List<User> person = htmlUtil.userList();

        Map<String, Object> data = new HashMap<>();

        data.put("userlogin", cookies[0].getValue());
        data.put("items", person);

        template.render("people-list.html", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
