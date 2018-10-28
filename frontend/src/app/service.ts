export class Service {
    id: number;
    name: string;
    locations: string[];
    age: string;
    gender: string;
    tags: string[];

    constructor(id: number, name: string, locations: string[], age: string, gender: string, tags: string[]) {
        this.id = id;
        this.name = name;
        this.locations = locations;
        this.age = age;
        this.gender = gender;
        this.tags = tags;
    }
}
