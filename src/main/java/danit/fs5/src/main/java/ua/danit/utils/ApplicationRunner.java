package danit.fs5.src.main.java.ua.danit.utils;

import danit.fs5.src.main.java.ua.danit.controller.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ua.danit.controller.FilterLogin;
import javax.servlet.DispatcherType;
import java.util.Arrays;
import java.util.EnumSet;

public class ApplicationRunner {
    public static void main(String[] args) throws Exception {
        ua.danit.utils.FreeMarker template = new ua.danit.utils.FreeMarker("./src/main/java/dan/fs5/lib/html");
        ServletContextHandler h = new ServletContextHandler();
        h.addServlet(new ServletHolder(new UserServlet(template)), "/users");
        h.addServlet(new ServletHolder(new LikedServlet(template)), "/liked");
        h.addServlet(new ServletHolder(new MessegeIdSevlet(template)), "/messeges/*");
        h.addServlet(new ServletHolder(new StaticServlet()), "/css/*");
        h.addServlet(new ServletHolder(new LoginServlet(template)), "/login");

        Arrays.asList("/users", "/messeges/*", "/liked")
                .forEach(path -> h.addFilter(FilterLogin.class,path, EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST)));

        Server server = new Server(8010);
        server.setHandler(h);
        server.start();
        server.join();
    }
}
