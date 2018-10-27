import { Injectable } from '@angular/core';
import {observable, Observable} from 'rxjs';
import { Observer } from 'rxjs';

import * as socketIo from 'socket.io-client';
import {Message} from './message';

const SERVER_URL = 'http://localhost:4567';

@Injectable({
    providedIn: 'root'
})
export class WebsocketService {

    private socket;

    constructor() {
    }

    public connect(): void {
        this.socket = socketIo(SERVER_URL);
    }

    public send(message: string): void {
        this.socket.emit('message', message);
    }

    public onMessage(){
        this.socket.on('message', function(data) {
            console.log('Got message from server ' + data);
        });
    }
}
