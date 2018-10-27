import {Component, OnInit} from '@angular/core';
import {Message} from '../message';
import {MessageService} from '../message.service';

@Component({
    selector: 'app-message',
    templateUrl: './message.component.html',
    styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {

    message: Message = {
        type: 0,
        message: 'Hi, what can I help you with today?'
    };

    constructor(public  messageService: MessageService) {}

    ngOnInit() {
    }

}
