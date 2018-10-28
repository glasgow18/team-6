export class Service {
    name: string;
    locations: string[];
    age: string;
    gender: string;
    tags: string[];

    constructor(name: string, locations: string[], age: string, gender: string, tags: string[]) {
        this.name = name;
        this.locations = locations;
        this.age = age;
        this.gender = gender;
        this.tags = tags;
    }
}
