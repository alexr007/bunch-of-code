package ua.danit.utils;

import ua.danit.dao.UserDAO;
import ua.danit.model.User;

import javax.servlet.http.Cookie;

public class GetLoginByCookie {

    public String getLogin(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userLogin")) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
