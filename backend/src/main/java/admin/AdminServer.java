package admin;

import com.codesnippets4all.json.serializers.JsonSerializer;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            json = new JSONObject(new String(Files.readAllBytes(Paths.get("backend/src/main/java/admin/services.txt"))));

            System.out.println("initial json " + json);

            sender.getRemote().sendString(String.valueOf(json));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFile(Session user, String msg) {

        JSONParser parser = new JSONParser();

            JSONObject message = new JSONObject(msg);
        System.out.println("message: " + message.get("id"));

            JSONArray services = json.getJSONArray("services");

        for (Object service : services) {
            String id = ((JSONObject)service).getString("id");
            System.out.println(message.get("id") + " " + id);

            if (id.equals(message.get("id").toString())) {
                ((JSONObject) service).put(message.getString("name"), message.getString("value"));
                System.out.println(services);
            }
        }

        try {
            PrintWriter printWriter = new PrintWriter("backend/src/main/java/admin/services.txt");
            printWriter.write("{\"services\":" + services + "}");
//            fileWriter.write("Hi");
            printWriter.close();
            System.out.println("Wrote");
        } catch (IOException e) {
            e.printStackTrace();
        }

//            services.getJSONObject(message.getJSONObject("id")).put(message.getJSONObject("name").toString(), message.getJSONObject("value"));
//
//            System.out.println(json.get("services"));



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
