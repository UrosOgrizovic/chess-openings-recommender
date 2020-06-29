import { NgModule } from '@angular/core';
import { AddRuleComponent } from './components/add-rule/add-rule.component';
import { AddRuleRoutingModule } from './add-rule-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [AddRuleComponent],
  imports: [
    AddRuleRoutingModule,
    FormsModule,
    MatSelectModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule]
})
export class AddRuleModule { }
