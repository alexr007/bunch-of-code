package ua.danit.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import ua.danit.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HtmlFreeMarker {

    public void getHtmlPage(Map<String, Object> map, HttpServletResponse resp, String htmlFile) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("./lib/html"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        Template template = cfg.getTemplate(htmlFile);
        PrintWriter writer = resp.getWriter();

        try {
            template.process(map, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
