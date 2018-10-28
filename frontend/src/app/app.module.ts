import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {TextfieldComponent} from './textfield/textfield.component';
import {MessageareaComponent} from './messagearea/messagearea.component';
import {MessageComponent} from './message/message.component';
import {AppRoutingModule} from './app-routing.module';
import {SuggestionsComponent} from './suggestions/suggestions.component';
import {FormsModule} from '@angular/forms';

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        TextfieldComponent,
        MessageareaComponent,
        MessageComponent,
        SuggestionsComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        AppRoutingModule,
        HttpClientModule,
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
