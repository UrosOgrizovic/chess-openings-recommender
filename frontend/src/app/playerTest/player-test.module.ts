import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlayerTestRoutingModule } from './player-test-routing.module';
import { PlayerTestComponent } from './components/player-test/player-test.component';
import { MatSelectModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [PlayerTestComponent],
  imports: [
    CommonModule,
    PlayerTestRoutingModule,
    MatSelectModule,
    MatButtonModule,
    BrowserAnimationsModule
  ]
})
export class PlayerTestModule { }
