package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class JettyServer {
    public static void main_1(String[] args) throws Exception {
        Server s = new Server(4001);
        HashMap<String, HttpServlet> map = new HashMap<>();
        map.put("/a", new Servlet1());
        map.put("/b", new Servlet2());
        map.put("/c", new Servlet3());
        map.put("/d", new Servlet4());
        s.setHandler(new ServletContextHandler() {{ map.forEach((a, s) -> addServlet(new ServletHolder(s), a)); }});
        s.start();
        s.join();
    }

    public static void main(String[] args) throws Exception {
        new Server(3000) {{
            setHandler(new ServletContextHandler(){{
                            addServlet(new ServletHolder(new HttpServlet() {
                                @Override
                                protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                                    resp.getWriter().write("hello world");
                                }
                            }),"/*");
                       }}
            );
            start();
            join();
        }};
    }
}
