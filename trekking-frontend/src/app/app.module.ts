import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrekkingComponent } from './trekking/trekking.component';
import { FormsModule } from '@angular/forms';
import { TrekkingDetailComponent } from './trekking-detail/trekking-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TrekkingCreateComponent } from './trekking-create/trekking-create.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BasicInterceptor } from './core/services/http-inteceptor';

@NgModule({
  declarations: [
    AppComponent,
    TrekkingComponent,
    TrekkingDetailComponent,
    MessagesComponent,
    DashboardComponent,
    TrekkingCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule  
  ],  
  providers: [{provide : HTTP_INTERCEPTORS, useClass: BasicInterceptor, multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
