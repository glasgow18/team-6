import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

import static spark.Spark.*;

public class Server {

    public static void main(String[] args) {
        staticFileLocation("");
        webSocket("/chat", ChatWebSocketHandler.class);
        init();
    }

    public static void sendMessage(Session sender, String msg){
        try{
            sender.getRemote().sendString(String.valueOf(new JSONObject().put("msg", msg)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
