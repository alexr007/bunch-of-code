package web;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import web.entities.Item;
import web.entities.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("./src/main/java/web/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        Map<String, Object> model = new HashMap<>();
        model.put("path", req.getRequestURI());
        model.put("requrl", req.getRequestURL().toString());
        model.put("params", req.getQueryString()==null ? "" : req.getQueryString());
        req.getPathInfo();
        model.put("user", "Alex");
        Product latest = new Product("http://www.ua", "new site");
        model.put("latestProduct", latest);
        ArrayList<Item> al = new ArrayList<>();
        al.add(new Item(1,"MacBook Pro", 1100));
        al.add(new Item(2,"Iphone 5S", 349));
        al.add(new Item(3,"IPad 4", 651));
        al.add(new Item(4,"mouse", 0));
        model.put("items", al);

        Template template = cfg.getTemplate("template1.ftlh");
        Writer out = resp.getWriter();

        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
