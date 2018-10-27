import { Injectable } from '@angular/core';
import {Message} from './message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
    public messages: Array<Message> = [];

    add(message: Message) {
        this.messages.push(message);
        console.log(message.message);
    }
}
