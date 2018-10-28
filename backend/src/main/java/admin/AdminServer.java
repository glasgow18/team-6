package admin;

import com.codesnippets4all.json.serializers.JsonSerializer;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static spark.Spark.*;

public class AdminServer {
    private static JSONObject json;

    public static void main(String[] args) {
        port(4568);
        staticFileLocation("");
        webSocket("/admin", AdminWebSocketHandler.class);
        init();
    }
    public static void initConnection(Session sender){
        try{
//            JSONParser parser = new JSONParser();

//            FileReader fileReader = new FileReader("backend/src/main/resources/services.txt");
            json = new JSONObject(new String(Files.readAllBytes(Paths.get("backend/src/main/resources/services.txt"))));

            System.out.println("initial json " + json);

            sender.getRemote().sendString(String.valueOf(json));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFile(Session user, String msg) {

        JSONParser parser = new JSONParser();
        try {

            JSONObject message = (JSONObject) parser.parse(msg);

            JSONObject services = json.getJSONObject("services");

            services.getJSONObject(message.getJSONObject("id").toString()).put(message.getJSONObject("name").toString(), message.getJSONObject("value"));

            System.out.println(json.get("services"));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
//    public static void sendMessage(Session sender, String msg){
//        try{
//            sender.getRemote().sendString(String.valueOf(new JSONObject().put("msg", msg)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void sendMsgWithReply(Session sender, String msg){
//        try{
//            if(!msg.equals(null)) {
//                List<String> r = Stemming.getStems(msg);
////                String reply = botMap.get(sender).poll(msg);
//                String reply = "reply";
//                JSONObject json = new JSONObject();
//
//                json.put("msg", msg);
//                json.put("reply", reply);
//                sender.getRemote().sendString(String.valueOf(json));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
