import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

import static j2html.TagCreator.*;
import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        staticFileLocation("");
        webSocket("/chat", ChatWebSocketHandler.class);
        init();
    }

//    public st
}
