import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlayerTestRoutingModule } from './player-test-routing.module';
import { PlayerTestComponent } from './components/player-test/player-test.component';
import { MatSelectModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [PlayerTestComponent],
  imports: [
    CommonModule,
    PlayerTestRoutingModule,
    MatSelectModule,
    MatButtonModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class PlayerTestModule { }
