import {Component, OnInit} from '@angular/core';
import {MessageService} from '../message.service';
import {Message} from '../message';

@Component({
    selector: 'app-textfield',
    templateUrl: './textfield.component.html',
    styleUrls: ['./textfield.component.scss']
})
export class TextfieldComponent implements OnInit {

    public textValue = '';

    constructor(private messageService: MessageService) {
    }

    ngOnInit() {
    }

    sendMessage(): void {
        if (this.textValue.trim() !== '') {
            const message: Message = {
                type: 1,
                message: this.textValue
            };
            this.messageService.send(message);  // TODO: change to message class
        }
        this.textValue = '';
    }
}
