import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

import static spark.Spark.*;

public class Server {
    private static Map<Session, ChatBot> botMap = new HashMap<>();
    public static void main(String[] args) {
        staticFileLocation("");
        webSocket("/chat", ChatWebSocketHandler.class);
        init();
    }
    public static void initConnection(Session sender){
        botMap.put(sender, new ChatBot("BOT NAME HERE"));
        try{
            sender.getRemote().sendString(String.valueOf(new JSONObject().put("msg", "You have connected")));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
//                String reply = botMap.get(sender).poll(msg);
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
}
