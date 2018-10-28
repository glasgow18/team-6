import {Injectable} from '@angular/core';
import {Service} from './service';

const SERVER_URL = 'ws://localhost:4568/admin';

@Injectable({
    providedIn: 'root'
})
export class AdminService {

    private webSocket;
    services: Service[] = [];

    constructor() {

    }

    public connect() {
        console.log('connecting');
        this.webSocket = new WebSocket(SERVER_URL);

        this.webSocket.onmessage = (msg => this.fetchServiceList(msg));
    }


    private fetchServiceList(msg) {
        const data = JSON.parse(msg.data);

        this.services.length = 0;

        data.services.forEach((jsonService, index) => {
            this.services.push(
                new Service(jsonService.id = index, jsonService.service, jsonService.location,
                    jsonService.age, jsonService.gender, jsonService.tags));
        });
    }

    public updateService(id: number, name: string, value: any) {

        this.webSocket.send(JSON.stringify({id, name, value}));

        // if (name === 'name') {
        //     this.webSocket.send(JSON.stringify({id, name, value}));
        //     // this.services[id].name = value;
        // }
        // if (name === 'location') {
        //     // this.services[id].locations = value.split(',');
        // }
        // if (name === 'age') {
        //     // this.services[id].age = value;
        // }
        // if (name === 'gender') {
        //     // this.services[id].gender = value;
        // }
        // if (name === 'tags') {
        //     // this.services[id].tags = value.split(',');
        // }

        // this.webSocket.send()
        // console.log(JSON.stringify(this.services[id]));
    }
}
