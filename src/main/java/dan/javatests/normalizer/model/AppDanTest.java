package dan.javatests.normalizer.model;

import dan.javatests.normalizer.model.servlets.ServletLogin;
import dan.javatests.normalizer.model.servlets.ServletLogout;
import dan.javatests.normalizer.model.servlets.ServletMenu;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class AppDanTest {
    public static void main(String[] args) throws Exception {
        FreeMarker template = new FreeMarker("./src/main/java/dan/javatests/normalizer/model/templates");
        new Server(8001) {{
            setHandler(new ServletContextHandler(){{
                addServlet(new ServletHolder(new ServletLogin()),"/login");
                addServlet(new ServletHolder(new ServletLogout()),"/logout");
                addServlet(new ServletHolder(new ServletMenu(template)),"/*");
                //Arrays.asList("/login").forEach(path -> addFilter(SimpleFilter.class,path, EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST)));
            }});
            start();
            join();
        }};
    }
}
