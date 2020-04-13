import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlayerTestComponent } from './components/player-test/player-test.component';


const routes: Routes = [{
  path: 'playerTypeTest',
  component: PlayerTestComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlayerTestRoutingModule { }
