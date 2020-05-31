import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddRuleComponent } from './components/add-rule/add-rule.component';

const routes: Routes = [{
  path: 'addRule',
  component: AddRuleComponent
}];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AddRuleRoutingModule { }
