package danit.fs5.src.main.java.ua.danit.controller;

import ua.danit.dao.MessegeDAO;
import ua.danit.dao.UserDAO;
import ua.danit.model.Messege;
import ua.danit.model.User;
import ua.danit.utils.Chat;
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

public class MessegeIdSevlet extends HttpServlet {
    private final FreeMarker template;

    public MessegeIdSevlet(FreeMarker template) {
        this.template=template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        GetLoginByCookie getLoginByCookie = new GetLoginByCookie();
        MessegeDAO messegeDAO = new MessegeDAO();
        Messege messege = new Messege();

        messege.setText(req.getParameter("newMessege"));
        messege.setWhoMessege(req.getParameter("myLogin"));
        messege.setWhomMessege(req.getParameter("login"));
        messege.setTime(System.currentTimeMillis());
        messege.setText(req.getParameter("newMessege"));

        messegeDAO.save(messege);

        Chat chat = new Chat();
        UserDAO userDAO = new UserDAO();

        Map<Long, Messege> chatMap = chat.getChat(messegeDAO.get(getLoginByCookie.getLogin(cookies), req.getParameter("login")),
                messegeDAO.get(req.getParameter("login"), getLoginByCookie.getLogin(cookies)), getLoginByCookie.getLogin(cookies));

        Map<String, Object> profile = new HashMap<>();
        User user = userDAO.get(req.getParameter("login"));

        profile.put("girlName", user.getName());
        profile.put("login", req.getParameter("login"));
        profile.put("photo", user.getPhotoURL());
        profile.put("myLogin", cookies[0].getValue());
        profile.put("girlLogin", req.getParameter("login"));
        profile.put("chatMap", chatMap);

        template.render("chat.html", profile, resp);
    }

}
