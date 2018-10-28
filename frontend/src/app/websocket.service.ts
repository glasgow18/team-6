import {Injectable} from '@angular/core';

const SERVER_URL = 'ws://localhost:4567/chat';

@Injectable({
    providedIn: 'root'
})
export class WebsocketService {

    // private webSocket;
    //
    // constructor() {
    //
    // }
    //
    // public connect() {
    //     this.webSocket = new WebSocket(SERVER_URL);
    //
    //     this.webSocket.onmessage = (msg => this.updateChat(msg));
    // }
    //
    // public updateChat(msg) {
    //
    // }


    // public connect(url): Subject<MessageEvent> {
    //     if (!this.subject) {
    //         this.subject = this.subject(url);
    //         console.log('Successfuly connected: ' + url);
    //     }
    //     return this.subject;
    // }
    //
    // private create(url): Subject<MessageEvent> {
    //     const ws = new WebSocket(url);
    //
    //     const observable = Observable.create(
    //         (obs: Observer<MessageEvent>) => {
    //             ws.onmessage = obs.next.bind(obs);
    //             ws.onerror = obs.error.bind(obs);
    //             ws.onclose = obs.complete.bind(obs);
    //             return ws.close.bind(ws);
    //         });
    //
    //     const observer = {
    //         next: (data: Object) => {
    //             if (ws.readyState === WebSocket.OPEN) {
    //                 ws.send(JSON.stringify(data));
    //             }
    //         }
    //     };
    //
    //     return Subject.create(observer, observable);
    // }
    //
    // public send(message: string): void {
    //     this.socket.emit('message', message);
    // }
    //
    // public onMessage() {
    //     this.socket.on('message', function(data) {
    //         console.log('Got message from server ' + data);
    //     });
    // }
}
