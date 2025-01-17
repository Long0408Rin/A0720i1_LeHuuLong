import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewsComponent } from './news/news.component';
import { LikesComponent } from './likes/likes.component';
import { NavabarComponent } from './navabar/navabar.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { CountdowntimerComponent } from './countdowntimer/countdowntimer.component';
import { CountdownTimerAliasComponent } from './countdown-timer-alias/countdown-timer-alias.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    LikesComponent,
    NavabarComponent,
    FooterComponent,
    HeaderComponent,
    CountdowntimerComponent,
    CountdownTimerAliasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
