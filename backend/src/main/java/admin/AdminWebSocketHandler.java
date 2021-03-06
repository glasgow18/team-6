package admin;

import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.Session;

@WebSocket
public class AdminWebSocketHandler {

    @OnWebSocketConnect
    public void onConnect(Session user){
        AdminServer.initConnection(user);
    }

    @OnWebSocketClose
    public void onClose(Session user, int status, String msg){
//        AdminServer.sendMessage(user, "You have disconnected from the server");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String msg){
        System.out.println("got a message");
        AdminServer.updateFile(user, msg);
    }
}
