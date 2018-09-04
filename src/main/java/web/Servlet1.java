package web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestURI = req.getRequestURI();
        String response = "Hello world, RequestURI = " + requestURI;
        String r = "<html><body><table>"+
                "<tr><td>1</td><td>2</td><td>3</td></tr>"+
                "<tr><td>hello</td><td>word</td><td>application</td></tr>"+
                "</table></body></html>";
        resp.getWriter().write(r);
    }
}
