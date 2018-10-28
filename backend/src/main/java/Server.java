import java.io.IOException;
import java.util.List;
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
    public static void sendMsgWithReply(Session sender, String msg){
        try{
            if(!msg.equals(null)) {
                List<String> r = Stemming.getStems(msg);
                // String reply = chatBot.poll(msg, sender);
                String reply = "reply";
                JSONObject json = new JSONObject();
                json.put("msg", msg);
                json.put("reply", reply);
                sender.getRemote().sendString(String.valueOf(json));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendWelcomeMessage(Session sender) {
        try{
            sender.getRemote().sendString(String.valueOf(new JSONObject().put("reply", "Hi there, how can I help you?")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
