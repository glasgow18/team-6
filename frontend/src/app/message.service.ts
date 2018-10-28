import { Injectable } from '@angular/core';
import {Message} from './message';

const SERVER_URL = 'ws://localhost:4567/chat';


@Injectable({
  providedIn: 'root'
})
export class MessageService {
    public messages: Array<Message> = [];
    private webSocket;


    add(message: Message) {
        this.messages.push(message);
    }

    constructor() {

    }

    public connect() {
        this.webSocket = new WebSocket(SERVER_URL);

        this.webSocket.onmessage = (msg => this.updateChat(msg));
    }

    public updateChat(msg) {
        const data = JSON.parse(msg.data);
        if (data.reply !== undefined) {
            const message: Message = {
                type: 0,
                message: data.reply
            };

            this.add(message);
        }
    }

    public send(message: Message) {
        this.add(message);
        this.webSocket.send(message.message);
    }

}
