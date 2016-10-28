import java.io.*;
import java.util.*;
import javax.servlet.http.*;

public class ConfigContainerDemo extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {

        Properties config = getConfig();

        resp.getWriter().write(
            "<html><body style='background-color: " +
            config.get("color") +
            "; font-size: 5em'><h1>" +
            config.get("label") +
            "</h1></body></html>");
    }

    private Properties getConfig()
        throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("/config/demo.properties"));
        return props;
	    }
}
