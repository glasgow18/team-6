import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.Session;

@WebSocket
public class ChatWebSocketHandler {

    @OnWebSocketConnect
    public void onConnect(Session user){
        Server.initConnection(user);
    }

    @OnWebSocketClose
    public void onClose(Session user, int status, String msg){
        Server.sendMessage(user, "You have disconnected from the server");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String msg){
        Server.sendMsgWithReply(user, msg);
    }
}
