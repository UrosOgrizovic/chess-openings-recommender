import { NgModule } from '@angular/core';
import { AddRuleComponent } from './components/add-rule/add-rule.component';
import { AddRuleRoutingModule } from './add-rule-routing.module';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AddRuleComponent],
  imports: [AddRuleRoutingModule,
  FormsModule]
})
export class AddRuleModule { }
