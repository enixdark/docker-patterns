import java.io.IOException;
import java.util.*;
import javax.servlet.http.*;

public class ConfigDemo extends HttpServlet {

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

    private Properties getConfig() {
        Properties ret = new Properties();
        ret.put("color",System.getenv("DEMO_COLOR"));
        ret.put("label",System.getenv("DEMO_LABEL"));
        return ret;
    }
}
