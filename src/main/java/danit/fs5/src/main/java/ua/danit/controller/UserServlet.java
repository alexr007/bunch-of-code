package danit.fs5.src.main.java.ua.danit.controller;

import ua.danit.dao.LikedDAO;
import ua.danit.dao.UserDAO;
import ua.danit.model.Liked;
import ua.danit.model.User;
import ua.danit.utils.FreeMarker;
import ua.danit.utils.GetLoginByCookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends HttpServlet {
    private final FreeMarker template;

    UserDAO userDAO = new UserDAO();
    GetLoginByCookie getLoginByCookie = new GetLoginByCookie();
    Map <Integer, User> girlsList = userDAO.getListOfUsers("woman");
    Map <Integer, User> boysList = userDAO.getListOfUsers("man");
    int count = 0;
    int stop = 0;

    public UserServlet(FreeMarker template) {
        this.template=template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Map<String, Object> profile = new HashMap<>();
        User user;

        if (userDAO.get(getLoginByCookie.getLogin(cookies)).getSex().equals("man")) {
            user = girlsList.get(count);
            stop = girlsList.size();

        } else {
            user = boysList.get(count);
            stop = boysList.size();
        }

        profile.put("name", user.getName());
        profile.put("photo", user.getPhotoURL());
        profile.put("login", user.getLogin());
        count++;

        template.render("like-page.html", profile, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if (req.getParameter("choise").equals("YES")) {
            Liked liked = new Liked();
            LikedDAO likedDAO = new LikedDAO();

            if (!likedDAO.getListOfLikedUsers(getLoginByCookie.getLogin(cookies)).contains(req.getParameter("login"))) {
                liked.setWhoLiked(getLoginByCookie.getLogin(cookies));
                liked.setWhomLiked(req.getParameter("login"));
                likedDAO.save(liked);
            }
        }
        if (count < stop) {
            Map<String, Object> profile = new HashMap<>();
            User user;

            if (userDAO.get(getLoginByCookie.getLogin(cookies)).getSex().equals("man")) {
                user = girlsList.get(count);
            } else {
                user = boysList.get(count);
            }

            profile.put("name", user.getName());
            profile.put("photo", user.getPhotoURL());
            profile.put("login", user.getLogin());
            count++;

            template.render("like-page.html", profile, resp);

        } else {
            resp.sendRedirect("/liked");
        }
    }

}
