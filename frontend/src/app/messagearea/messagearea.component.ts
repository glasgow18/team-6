import {AfterViewChecked, Component, ElementRef, HostListener, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {MessageService} from '../message.service';

@Component({
    selector: 'app-messagearea',
    templateUrl: './messagearea.component.html',
    styleUrls: ['./messagearea.component.scss']
})
export class MessageareaComponent implements OnInit, AfterViewChecked {

    constructor(public  messageService: MessageService) {
    }

    @ViewChild('scrollMe') private myScrollContainer: ElementRef;

    ngOnInit() {
        this.messageService.connect();
        this.scrollToBottom();
    }

    ngAfterViewChecked() {
        this.scrollToBottom();
    }

    scrollToBottom(): void {
        try {
            this.myScrollContainer.nativeElement.scrollTop = this.myScrollContainer.nativeElement.scrollHeight;
        } catch (err) { }
    }

}
