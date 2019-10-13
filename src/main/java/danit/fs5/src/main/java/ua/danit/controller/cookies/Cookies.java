package ua.danit.controller.cookies;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cookies {
    private final Map<String, Cookie> cookies;

    public Cookies(ServletRequest request) {
        this((HttpServletRequest)request);
    }

    public Cookies(HttpServletRequest req) {
        this(req.getCookies());
    }

    public Cookies(Cookie[] cookies) {
        this.cookies = new NullableArrayWrapper<>(cookies)
                .get()
                .stream()
                .collect(Collectors.toMap(Cookie::getName, Function.identity()));
    }

    public boolean exists(String name) {
        return cookies.containsKey(name);
    }

    public Cookie get(String name) {
        return cookies.get(name);
    }

    public String getValue(String name) {
        return cookies.containsKey(name) ? get(name).getValue() : "";
    }

    public int getAge(String name) {
        return cookies.get(name).getMaxAge();
    }

    public static void main(String[] args) {
        Cookie c2 = new Cookie("1", "2");
        Cookie c1 = new CookieTimed("login", "alex", 60);
        Cookie[] cc =null;
        Cookies cookies = new Cookies(cc);
        System.out.println(cookies.getValue("login"));
    }
}
