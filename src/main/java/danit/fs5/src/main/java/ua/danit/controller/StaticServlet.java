package danit.fs5.src.main.java.ua.danit.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StaticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //byte[] buffer = FileUtils.readFileToString(new File(),"UTF-8").getBytes();
        resp.getOutputStream()
                .write(Files.readAllBytes(
                        Paths.get("lib", req.getPathInfo())));
    }
}
