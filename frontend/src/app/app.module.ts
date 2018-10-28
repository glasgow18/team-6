import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';


import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {TextfieldComponent} from './textfield/textfield.component';
import {MessageareaComponent} from './messagearea/messagearea.component';
import {AppRoutingModule} from './app-routing.module';
import {SuggestionsComponent} from './suggestions/suggestions.component';
import {FormsModule} from '@angular/forms';
import {AdminComponent} from './admin/admin.component';
import {ChatComponent} from './chat/chat.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material';

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        TextfieldComponent,
        MessageareaComponent,
        SuggestionsComponent,
        AdminComponent,
        ChatComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        AppRoutingModule,
        HttpClientModule,
        BrowserAnimationsModule,
        MatTableModule,
    ],
    providers: [],
    bootstrap: [AppComponent]
})

export class AppModule {
}
