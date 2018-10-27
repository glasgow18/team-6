import {Component, OnInit} from '@angular/core';
import {MessageService} from '../message.service';
import {WebsocketService} from '../websocket.service';
import {Message} from '../message';

@Component({
    selector: 'app-messagearea',
    templateUrl: './messagearea.component.html',
    styleUrls: ['./messagearea.component.scss']
})
export class MessageareaComponent implements OnInit {
    constructor(public  messageService: MessageService, private socketService: WebsocketService) {
    }

    ngOnInit() {
        this.connect();
    }

    private connect() {
        this.socketService.connect();
        this.socketService.send('hello');
        this.socketService.onMessage();
    }
}
