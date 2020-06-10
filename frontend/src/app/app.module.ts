import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';
import { HomeModule } from './home/home.module';
import { PlayerTestModule } from './playerTest/player-test.module';
import { HttpClientModule } from '@angular/common/http';
import { ChessGameModule } from './chess-game/chess-game.module';
import { AddRuleModule } from './add-rule/add-rule.module';
import { ToastrModule } from 'ngx-toastr';
import { SharedModule } from './shared/shared.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    CoreModule,
    PlayerTestModule,
    HttpClientModule,
    ChessGameModule,
    AddRuleModule,
    SharedModule,
    BrowserAnimationsModule, // required animations module for toastr
    ToastrModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
