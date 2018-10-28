import {Component, OnInit} from '@angular/core';
import {MessageService} from '../message.service';
import {WebsocketService} from '../websocket.service';

@Component({
    selector: 'app-messagearea',
    templateUrl: './messagearea.component.html',
    styleUrls: ['./messagearea.component.scss']
})
export class MessageareaComponent implements OnInit {
    constructor(public  messageService: MessageService) {
    }

    ngOnInit() {
        this.messageService.connect();
    }
}
