import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.xml.bind.DatatypeConverter;

import com.ecwid.consul.json.Base64TypeAdapter;
import com.ecwid.consul.v1.ConsulClient;

public class ConfigServiceDemo extends HttpServlet {

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
        ConsulClient client = new ConsulClient("consul");

        Properties ret = new Properties();
        ret.put("color", getValue(client, "demo/color"));
        ret.put("label", getValue(client, "demo/label"));
        return ret;
    }

    private String getValue(ConsulClient client, String what) {
        String base64 = client.getKVValue(what).getValue().getValue();
        return new String(DatatypeConverter.parseBase64Binary(base64));
    }
}
